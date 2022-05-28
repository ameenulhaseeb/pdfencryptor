package com.gulteking.pdfencryptor.service;

import com.gulteking.pdfencryptor.exception.ExceptionMessages;
import com.gulteking.pdfencryptor.exception.InternalException;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;

@Slf4j
@Service
@PropertySource("classpath:application.properties")
public class PdfEncryptorService {
    @Value("${pdf.key.length}")
    private int keyLength;

    @Autowired
    private Environment env;
    
    public byte[] encryptPdf(MultipartFile file, String password) {
        try {
        	//int keyLength=Integer.parseInt(env.getProperty("pdf.key.length"));
            byte[] sourcePdfBytes = file.getBytes();
            PDDocument doc = PDDocument.load(sourcePdfBytes);

            AccessPermission ap = new AccessPermission();
            ap.setCanPrint(false);
            ap.setCanAssembleDocument(false);
            ap.setCanExtractContent(false);
            ap.setCanExtractForAccessibility(false);
            ap.setCanFillInForm(false);
            ap.setCanModify(false);
            ap.setCanModifyAnnotations(false);
            ap.setCanPrintDegraded(false);
            StandardProtectionPolicy spp = new StandardProtectionPolicy(
                    password, password, ap);

            spp.setEncryptionKeyLength(256);
            doc.protect(spp);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            doc.save(baos);
            doc.close();

            return baos.toByteArray();
        } catch (Exception ex) {
            log.error("Exception occured while encrypting pdf", ex);
            throw new InternalException(ExceptionMessages.UNHANDLED_EXCEPTION, ex);
        }
    }

}

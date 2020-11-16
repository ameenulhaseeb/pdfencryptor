
  
## PDF ENCRYPTOR  
A Spring Boot application that adds password protection to pdf files.  
 
## FEATURES
Adds password to  pdf files, just send a post request to /pdf endpoint and give file & password.   

Then download your encrypted pdf file. You will be able to open encrypted pdf file when you enter correct password .
 

## TOOLS
 - Java 8
 - Spring Boot 2.4.0
 - Apache PDFBox 2
 - Lombok

## COMPILE AND RUN
**Compile**  
Requires **jdk8** and **maven**

    mvn clean install
`target/pdfencryptor-0.0.1-SNAPSHOT.jar` file should be generated.

**Run**  

    java -jar target/pdfencryptor-0.0.1-SNAPSHOT.jar  
Application will run from 8090 port. 

**Change Port**

You can change port from `src/main/resources/application.properties` 
Or give your custom port with `-Dserver.port` parameter like this; 

    java -Dserver.port=8888 -jar target/pdfencryptor-0.0.1-SNAPSHOT.jar

## SAMPLE REQUEST
Following curl request sends **sample.pdf** fıle to server for encryptıon. And sets **12345678** as password. Then saves encrypted pdf file as **sample_encrypted.pdf** .

    curl --location --request POST 'localhost:8090/pdf' \
    --form 'file=@sample.pdf' \
    --form 'password=12345678' -o 'sample_encrypted.pdf'


## DEPLOYMENT
This repository has not deployed to anywhere, just download jar file from [releases](https://github.com/gulteking/pdfencryptor/releases) and run from your own environment. 

## DEVELOPERS
 - Mehmet Fatih Gültekin (gultekin.mehmetfatih@gmail.com)
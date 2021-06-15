# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8
ADD target/gestioncours.jar gestioncours.jar
EXPOSE 20000
ENTRYPOINT ["java","-jar","/gestioncours.jar"]


#!/bin/bash
##SCRIPT D'EXECUTION DE COUVERTURE DE CODE
## SUPRESSION DES ANCIENS RAPPORTS ET INSTRUMENTATION

rm -rf destination/* instrumented/* cobertura.ser ../target/test/java/org/emiage/GrilleTest.class  ../target/main/java/org/emiage/GrilleImpl.class

##COMPILATION DE MON CODE

javac -d ../target/ main/java/org/emiage/Grille.java
javac -d ../target/ main/java/org/emiage/GrilleImpl.java
javac -cp ../cobertura-2.1.1/lib/junit-4.11.jar:../target/ test/java/org/emiage/GrilleTest.java -d ../target/

##INSTRUMENTATION
../cobertura-2.1.1/cobertura-instrument.sh --destination ../instrumented/ ../target/main/java/org/emiage/GrilleImpl.class ../target/test/java/org/emiage/GrilleTest.class
cp ../target/main/java/org/emiage/Grille.class ../instrumented/main/java/org/emiage/

##EXECUTION DU CODE INSTRUMENTE
java -cp ../cobertura-2.1.1/cobertura-2.1.1.jar:../cobertura-2.1.1/lib/slf4j-api-1.7.5.jar:../cobertura-2.1.1/lib/logback-core-1.0.13.jar:../cobertura-2.1.1/lib/logback-classic-1.0.13.jar:../cobertura-2.1.1/lib/junit-4.11.jar:./../instrumented: test/java/org/emiage/GrilleTest

## GENERATION DU RAPPORT
../cobertura-2.1.1/cobertura-report.sh --datafile cobertura.ser --format html --destination ../destination/

## AFFICHAGE DU RAPPORT
firefox ../destination/index.html

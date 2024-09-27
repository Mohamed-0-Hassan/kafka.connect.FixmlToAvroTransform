# FIXML to Avro Kafka Connect Transformation

This project provides a Kafka Connect transformation that parses FIXML messages and converts them into Avro format.

## Overview

The transformation, `FixmlToAvroTransform`, is a Kafka Connect Single Message Transform (SMT) that processes incoming messages in FIXML format and converts them into an Avro-serialized record for downstream use.

## Structure

- **Transform Class**: `FixmlToAvroTransform` is the main class responsible for parsing FIXML messages and converting them to Avro format.
- **Test Class**: `FixmlToAvroTransformTest` provides unit tests to validate the functionality of the transformation.
- **Resources**: The `pom.xml` contains necessary dependencies for Kafka Connect, Avro, and JUnit.

## Features

- **FIXML Parsing**: The transform uses an XML parser to extract data from FIXML messages.
- **Conversion to Avro**: The parsed data is mapped to a predefined Avro schema.
- **Kafka Connect Integration**: The SMT can be integrated into any Kafka Connect source or sink to transform FIXML messages on the fly.

## Requirements

- **Java 11 or later**
- **Maven** for build and dependency management
- **Kafka Connect API** for developing the SMT
- **Avro** for schema serialization
- **JUnit 5** for testing

## Usage

1. **Building the Project**: Use Maven to build the project.
   ```bash
   mvn clean package
This will generate a JAR file in the target directory.

Configuring Kafka Connect: Add the JAR file to your Kafka Connect classpath and configure the SMT in your connector configuration:

properties

Copy Code 
transforms=FixmlToAvro
transforms.FixmlToAvro.type=com.example.kafka.connect.transform.FixmlToAvroTransform
Testing the Transformation: Run the tests to ensure that the transformation works as expected:

bash

Copy Code
mvn test
Example FIXML Input
Below is an example of a FIXML message that the transform is capable of parsing:

xml

Code kopiëren
<FIXML v="FIX50SP2" s="20080115">
    <SecDef RptID="3400001" ReqID="1234567" RspTyp="100">
    <Hdr SID="CME" TID="BRKR" SSub="CPAPI " TSub="user" />
    <Instrmt ID="CS" Src="H" ProdCmplx="ENRGY" SecTyp="FUT" MinPxIncr="0.01"
                UOM="Bbl" UOMQty="1000" PxUOM="Bbl" PxUOMQty="1" SettlMeth="C"
                PxQteMeth="STD" ListMeth="0" TmUnit="Mo" Exch="NYMEX" Desc="WTI Calendar Swap" />
    <InstrmtExt>
        <Attrb Typ="29" Val="Y" />
        <Attrb Typ="25" Val="1" />
        <Attrb Typ="24" Val="2" />
        <Attrb Typ="24" Val="12" />
    </InstrmtExt>
    </SecDef>
</FIXML>
Avro Conversion
The transformation logic parses the FIXML message and maps relevant elements and attributes to an Avro schema. The schema must be defined and aligned with the data structure within the FIXML.

Development
Feel free to modify the transformation logic to handle additional FIXML messages or customize the Avro schema to fit your data needs.

License
This project is licensed under the MIT License - see the LICENSE file for details.

© 2024 Astream B.V. """

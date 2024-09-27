
package io.astream.kafka.connect.transform;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.source.SourceRecord;
import org.junit.jupiter.api.Test;

import io.example.kafka.connect.transform.FixmlToAvroTransform;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class FixmlToAvroTransformTest {

    // Updated FIXML example with real content
    private static final String FIXML_EXAMPLE = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<FIXML v=\"FIX50SP2\" s=\"20080115\">\n" +
            "    <SecDef RptID=\"3400001\" ReqID=\"1234567\" RspTyp=\"100\">\n" +
            "    <Hdr SID=\"CME\" TID=\"BRKR\" SSub=\"CPAPI \" TSub=\"user\" />\n" +
            "    <Instrmt ID=\"CS\" Src=\"H\" ProdCmplx=\"ENRGY\" SecTyp=\"FUT\" MinPxIncr=\"0.01\"\n" +
            "                UOM=\"Bbl\" UOMQty=\"1000\" PxUOM=\"Bbl\" PxUOMQty=\"1\" SettlMeth=\"C\"\n" +
            "                PxQteMeth=\"STD\" ListMeth=\"0\" TmUnit=\"Mo\" Exch=\"NYMEX\" Desc=\"WTI Calendar Swap\" />\n" +
            "    <InstrmtExt>\n" +
            "        <Attrb Typ=\"29\" Val=\"Y\" />\n" +
            "        <Attrb Typ=\"25\" Val=\"1\" />\n" +
            "        <Attrb Typ=\"24\" Val=\"2\" />\n" +
            "        <Attrb Typ=\"24\" Val=\"12\" />\n" +
            "    </InstrmtExt>\n" +
            "    </SecDef>\n" +
            "</FIXML>";

    private static final String EXPECTED_AVRO_OUTPUT = "Transformed Avro content"; // Replace with actual expected Avro

    @Test
    public void testTransform() {
        // Initialize the transform
        FixmlToAvroTransform<SourceRecord> transform = new FixmlToAvroTransform<>();

        // Create a sample SourceRecord with FIXML as the value
        SourceRecord record = new SourceRecord(
                Collections.singletonMap("key", "value"), // Source partition
                Collections.singletonMap("offset", 1),   // Source offset
                "test-topic",                           // Topic name
                Schema.STRING_SCHEMA,                   // Key schema
                "test-key",                             // Key
                Schema.STRING_SCHEMA,                   // Value schema
                FIXML_EXAMPLE                           // FIXML message as value
        );

        // Apply the transform
        SourceRecord transformedRecord = transform.apply(record);

        // Assert that the transformed value matches the expected Avro content
        assertEquals(EXPECTED_AVRO_OUTPUT, transformedRecord.value());
    }
}

package parsers;

import org.junit.jupiter.api.Test;

class XMLValidatorTest {
    public static final String XML_VALID_PATH = "src/main/resources/planes.xml";
    public static final String XSD_PATH = "src/main/resources/planes.xsd";

    @Test
    void validTest() {
        XMLValidator.validateAgainstXSD(XML_VALID_PATH, XSD_PATH);
    }
}

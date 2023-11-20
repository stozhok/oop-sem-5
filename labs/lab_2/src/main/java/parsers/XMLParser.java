package parsers;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

interface XMLParser<T>{
    List<T> parse(String dataFilepath, String schemaFilepath, XMLBuilder<T> builder) throws
            ParserConfigurationException,
            IOException,
            SAXException,
            XMLStreamException;
}
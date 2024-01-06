import org.xml.sax.XMLReader;
import org.xml.sax.Attributes;
import java.net.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;

/**
 * bancaSaxParser
 */
class bancaSaxParser extends DefaultHandler {
    boolean bNome = false;
    boolean bCognome = false;
    private String nome;
    private String cognome;

    public void startElement(String namespace, String rawName, String dato, Attributes atts) {
        // System.out.println("startElement: " + dato);
        if (dato.equals("nome")) {
            bNome = true;
        } else if (dato.equals("cognome")) {
            bCognome = true;
        }
    }

    public void characters(char[] stringa, int inizio, int lunghezza) {
        // System.out.println("characters: " + new String(stringa, inizio, lunghezza));
        if (bCognome) {
            nome = new String(stringa, inizio, lunghezza);
        } else if (bNome) {
            cognome = new String(stringa, inizio, lunghezza);
        }
    }

    public void endElement(String namespace, String rawName, String dato) {
        // System.out.println("endElement: " + dato);
        if (dato.equals("nome")) {
            bNome = false;
        } else if (dato.equals("cognome")) {
            bCognome = false;
        }
    }
}

/**
 * Parser
 */
public class SaxParser {

    public static void main(String[] args) throws Exception {
        // a) creazione della Factory col metodo static newInstance
        SAXParserFactory spf = SAXParserFactory.newInstance();
        // b) creazione del SAXparser
        SAXParser saxParser = spf.newSAXParser();
        // c) creazione del Reader
        XMLReader xmlReader = saxParser.getXMLReader();
        // d) lettura e parse del file
        try {
            DefaultHandler handler = new bancaSaxParser();
            xmlReader.setContentHandler(handler);
            System.err.println("Parsing del file banca.xml");
            xmlReader.parse("banca.xml");
        } catch (Exception e) {
            System.err.println("Errore durante il parsing del file");
        }
    }
}
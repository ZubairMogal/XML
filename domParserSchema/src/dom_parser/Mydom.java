package dom_parser;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Mydom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc=builder.parse("xml.xml");
			NodeList vehiclesList=doc.getElementsByTagName("vehicles");
			for(int i=0;i<vehiclesList.getLength();i++)
			{
				Node p=vehiclesList.item(i);
				if(p.getNodeType()==Node.ELEMENT_NODE)
				{
					Element vehicles=(Element) p;
					String id= vehicles.getAttribute("id");
					NodeList nameList=vehicles.getChildNodes();
					for(int j=0;j<nameList.getLength();j++)
					{
						Node n=nameList.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE)
						{
							Element name=(Element) n;
							System.out.println("vehicles "+id+":"+name.getTagName()+"="+name.getTextContent());
						}
						
					}
			}
		}
	}
		catch(ParserConfigurationException e)
		{
			e.printStackTrace();
	}
		catch(SAXException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

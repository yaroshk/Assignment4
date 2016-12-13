package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.beust.jcommander.*;

@Parameters(separators = "=")
public class Property_External_CLO {

	Properties p = new Properties();

	static Property_External_CLO pf = new Property_External_CLO();

	@Parameter(names = { "-f", "--p_file" }, description = "Properties File", required = true)

	static String pf_out = null;

	String getPropertyCLO(String prop_file, String property) throws IOException {

		p.load(new FileInputStream(prop_file));

		return p.getProperty(property);

	}

	public static void main(String[] args) throws IOException {

		new JCommander(new Property_External_CLO(), args);

		System.out.println("Title: \t\t\t\t" + pf.getPropertyCLO(pf_out, "title"));

		System.out.println("First Name: \t\t\t" + pf.getPropertyCLO(pf_out, "first_name"));

		System.out.println("Last Name: \t\t\t" + pf.getPropertyCLO(pf_out, "last_name"));

		System.out.println("Current directory: \t\t" + System.getProperty("user.dir"));

		System.out.println("Properties file location: \t" + new java.io.File(pf_out).getCanonicalPath());

	}

}

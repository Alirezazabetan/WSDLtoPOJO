# Converting WSDL to POJOs Using Java

If you find yourself mapping WSDL to POJOs but don't want to write a full class, help yourself to a handy library that does the work for you.

If you have WSDL that you want to map into a POJO without writing the full POJO class, then you can make use of the WSDLtoPOJO library. This is an excellent library that can create Java classes using your input WSLD.

After foorking and give a star point 

Run the following commands in terminal to create Pojo files from WSDL adn store on your hard drive.

    mvn compile

##Test
After that you have some POJOs and object-factory that you can use them to JAXB. I provide a test sample for this porpose.

    mvn test

If you want to change the builder package you must change addresses in two places. first on config class

```java
@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this is the package name specified in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.zabetan.behpardakht.ipg.schemas");
		marshaller.setCheckForXmlRootElement(false);
		return marshaller;
	}
```

and also in pom.xml file: 

```java
<configuration>
					<generatePackage>com.zabetan.behpardakht.ipg.schemas</generatePackage>
					<generateDirectory>${project.basedir}/src/main/java</generateDirectory>
					<schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
					<schemaIncludes>
						<include>*.wsdl</include>
					</schemaIncludes>
</configuration>
```

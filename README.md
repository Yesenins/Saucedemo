1.all added goods are displayed in the cart (passed)
2.the cart icon displays the added quantity of goods (passed with adding and removing goods)(passed)
3.for each item the name is displayed, price  (passed)
4.the price without tax coincides with the total cost of goods (
passed)
5.the item can be removed from the cart (disappears after removal)(passed)



mvn versions:display-dependency-updates
[INFO] Scanning for projects...
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-metadata.xml (14 kB at 25 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/maven-metadata.xml (21 kB at 35 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/versions-maven-plugin/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/versions-maven-plugin/maven-metadata.xml (1.3 kB at 35 kB/s)
[INFO]
[INFO] -----------------------< org.example:Saucedemo >------------------------
[INFO] Building Saucedemo 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions:2.18.0:display-dependency-updates (default-cli) @ Saucedemo ---
Downloading from central: https://repo.maven.apache.org/maven2/org/testng/testng/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/org/hamcrest/hamcrest/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/org/seleniumhq/selenium/selenium-java/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/org/assertj/assertj-core/maven-metadata.xml
Downloading from central: https://repo.maven.apache.org/maven2/io/github/bonigarcia/webdrivermanager/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/hamcrest/hamcrest/maven-metadata.xml (577 B at 13 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/seleniumhq/selenium/selenium-java/maven-metadata.xml (5.6 kB at 120 kB/s)        
Downloaded from central: https://repo.maven.apache.org/maven2/org/assertj/assertj-core/maven-metadata.xml (2.7 kB at 26 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/testng/testng/maven-metadata.xml (3.1 kB at 29 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/io/github/bonigarcia/webdrivermanager/maven-metadata.xml (3.2 kB at 28 kB/s)
[INFO] No dependencies in Dependencies have newer versions.
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.796 s
[INFO] Finished at: 2025-02-19T18:30:07+03:00
[INFO] ------------------------------------------------------------------------


mvn versions:use-latest-versions
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< org.example:Saucedemo >------------------------
[INFO] Building Saucedemo 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions:2.18.0:use-latest-versions (default-cli) @ Saucedemo ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.584 s
[INFO] Finished at: 2025-02-19T18:31:18+03:00
[INFO] ------------------------------------------------------------------------

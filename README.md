# CallGraph
Assignment for the Compilers (IF688) course. This is a demonstration of a call-graph generator; a sample file is used as an example, and specific tests are made on top of its call-graph.

### Setting up on Eclipse
- Import the project into Eclipse.
- Download WALA at https://github.com/wala/wala. Import the following projects:
  - com.ibm.wala.core
  - com.ibm.wala.core.testdata
  - com.ibm.wala.core.tests
  - com.ibm.wala.ide
  - com.ibm.wala.shrike
  - com.ibm.wala.util
- Add those projects into the Compiladores project.
- At com.ibm.wala.core, open the ```dat``` folder and change the ```wala.properties``` file. Find the ```java_runtime_dir``` variable and change it according to your JRE's path.

### Testing
This project contains one sample code that contains mutual recursion procedures. Thus, its call-graph contains cycles; a test has been made to make that assertion. It checks if one method is contained in the other's graph edge, and vice-versa. 
The project also contains a test that verifies if a class has been instantiated but not used. It checks the existence of a class initialization and the ausence of this class' method.

To test them, add JUnit to your project, and right-click then select Run As > JUnit Test.

### Thanks
Thanks to Marlon (mras@cin.ufpe.br) for providing the base of this project (https://github.com/marlonwc3/CallGraphIF688).

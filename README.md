# io.mersys.test.team1
The Complete functional test of the mersys.io application which in the education domain.

## CONTRIBUTERS: 
Barış Özalpay : barisozalpay7@gmail.com

Haşir Dut : av.hasirdut@gmail.com

Muharrem Karapazar : m.karapazar2@gmail.com

Raziya Nur : raziyanur04@gmail.com

Sema Nur Arslan : sa.semanurarslan@gmail.com

Yener Kıpırdı : yenerki@gmail.com

Hakan Taşdelen : hakann.tasdelenn@gmail.com

---

+ https://www.jetbrains.com/help/idea/maven-support.html#create_new_maven_project <br>
+ https://www.jetbrains.com/help/idea/cucumber-support.html <br>
+ https://www.jetbrains.com/help/idea/testng.html <br>

---

* 1- Yeni projeye tıklattım -> Proje Tipi olarak MAVEN seçildi -> JAVA>JDK 1.8 seçildi.

* 2- Klasör yapısını inceledik: 
	main -> Developer'ın source kodları;  
	test -> Tester'ın kodları

* 3- Maven'ın verdiği düzenli yapının kendi tarafımızda , bizde kendi düzenli klasör yapımızı oluşturacağız. 
	Klasörler:
	FeatureFiles -> Senaryolarımızın olduğu klasör 
	StepDefinitions-> Senaryoların çalışan adımları [Metodları burada olacak] 
	Pages -> Page Object Model sayfalarımız [POM (@FindBy)] 
	Utilities -> Driver ve diğer tekrar kullanılacak metodlarımız 
	Runners -> Çalıştırıcılar


* 4- AYARLAR 

	A) Intellij Editör ayarları 2 tane Plugin ekleyeceğiz 
	1- Cucumber for Java 
	2- Gherkin Language

+ https://cucumber.io/docs/gherkin/reference/#keywords

	Feature Scenario Given-When-Then-And-Or
	Examples follow this same pattern:
	Describe an initial context (Given steps)
	Describe an event (When steps)
	Describe an expected outcome (Then steps)
	""" (Doc Strings)
	| (Data Tables)
	@ (Tags)
	\# (Comments)
	
	
	B) POM.xml -> Project Object Model Ayarları
	Selenium
	Cucumber
	testNG
	Cucumber		[testNG birleştiren lib]
	Webdriver		[WebDriverManager  //5.1.0]
	Properties'de	[ByteCode version(1.8) ayarı]

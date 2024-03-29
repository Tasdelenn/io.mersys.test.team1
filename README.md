# io.mersys.test.team1

The Complete functional test of the mersys.io application which in the education domain.

---

## CONTRIBUTERS:

NAME | E-MAIL | GITHUB
--- | --- | ---
Barış Özalpay | barisozalpay7@gmail.com |https://github.com/Bariss7
Haşir Dut | av.hasirdut@gmail.com |https://github.com/mehmethasirdut
Muharrem Karapazar | m.karapazar2@gmail.com |https://github.com/Muharrem-TR
Raziya Nur | raziyanur04@gmail.com |https://github.com/raziyanur
Sema Nur Arslan | sa.semanurarslan@gmail.com |https://github.com/sasemanur
Tuğba Akbunar | tugbaakbunar6@gmail.com |https://github.com/tugbAkbunar93
Yener Kıpırdı | yenerki@gmail.com |https://github.com/yenerki
Yasin Erkol | enderimhafsam@gmail.com |https://github.com/yasinerkol
Hakan Taşdelen | hakann.tasdelenn@gmail.com |https://github.com/Tasdelenn

---

+ https://www.jetbrains.com/help/idea/maven-support.html#create_new_maven_project

+ https://www.jetbrains.com/help/idea/cucumber-support.html

+ https://www.jetbrains.com/help/idea/testng.html

---

1) Yeni projeye tıklattım -> Proje Tipi olarak MAVEN seçildi -> JAVA>JDK 1.8 seçildi.
2) Klasör yapısını inceledik: <br>
   main -> Developer'ın source kodları <br>
   test -> Tester'ın kodları
3) Maven'ın verdiği düzenli yapısını takip ederek, biz de kendi düzenli klasör yapımızı oluşturacağız. <br>
   **[Klasörler]** : <br>
   *FeatureFiles* -> Senaryolarımızın olduğu klasör <br>
   *StepDefinitions* -> Senaryoların çalışan adımları [Metodları burada olacak] <br>
   *Pages* -> Page Object Model sayfalarımız [POM (@FindBy)] <br>
   *Utilities* -> Driver ve diğer tekrar kullanılacak metodlarımız <br>
   *Runners* -> Çalıştırıcılar


4) **AYARLAR**

   **A)** Intellij Editör ayarları (2 tane Plugin ekleyeceğiz)
    1) Cucumber for Java
    2) Gherkin Language

+ https://cucumber.io/docs/gherkin/reference/#keywords

  **Feature** <br>
  **Scenario** <br>
  **Background** <br>
  **Given - When - Then - And - Or** <br>
  Examples follow this same pattern: <br>
  Describe an initial context *(**Given** steps)* <br>
  Describe an event *(**When** steps)* <br>
  Describe an expected outcome *(**Then** steps)* <br>
  (""") *Doc Strings* <br>
  (|) *Data Tables* <br>
  (@) *Tags* <br>
  (#) *Comments* <br> <br>

**B)** POM.xml -> Project Object Model Ayarları <br>

* Selenium <br>
* Cucumber <br>
* TestNG <br>
* Cucumber & TestNG        [testNG birleştiren lib] <br>
* Webdriver        [WebDriverManager Boni Garcia ver.5.3.0] <br>
* Properties'de    [ByteCode version(1.8) ayarı] <br>

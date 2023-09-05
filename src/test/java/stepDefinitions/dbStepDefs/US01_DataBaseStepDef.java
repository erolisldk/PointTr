package stepDefinitions.dbStepDefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DatabaseUtility;

import java.util.HashMap;
import java.util.Map;

public class US01_DataBaseStepDef {

    Map<String, Object> registerMap = new HashMap<String, Object>();

    @Given("Kullanici database baglantisi olusturur")
    public void kullanici_database_baglantisi_olusturur() {
        DatabaseUtility.createConnection();

    }

    @When("Kullanici sorguyu db'ye gonderir ve {string} ssn numarali kullanici verilerini alir")
    public void kullaniciSorguyuDbYeGonderirVeSsnNumaraliKullaniciVerileriniAlir(String ssn) {

        String query = "select * from jhi_user where ssn=\'" + ssn + "\'";
        registerMap.putAll(DatabaseUtility.getRowMap(query));
        System.out.println("ssnMap = " + registerMap);

    }


    @Then("Kullanici db verisini dogrular {string}")
    public void kullaniciDbVerisiniDogrular(String ssn) {

        Map<String, Object>expectedData = new HashMap<String, Object>();
        expectedData.put("ssn", ssn);
        Assert.assertTrue(registerMap.entrySet().containsAll(expectedData.entrySet()));
    }

    @When("Kullanici sorguyu db'ye gonderir ve kullanici verilerini {string} girisiyle alir")
    public void kullaniciSorguyuDbYeGonderirVeKullaniciVerileriniGirisiyleAlir(String login) {

        String query="select * from jhi_user where login=\'"+login+"\'";
        registerMap.putAll(DatabaseUtility.getRowMap(query));
        System.out.println("registerMap = " + registerMap);
    }

    @When("Kullanici db verisini dogrularr {string}")
    public void kullaniciDbVerisiniDogrularr(String email) {

        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("email",email);
        Assert.assertTrue(registerMap.entrySet().containsAll(expectedData.entrySet()));
    }
}


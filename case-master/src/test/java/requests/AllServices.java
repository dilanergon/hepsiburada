package requests;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestRunner;
import com.consol.citrus.http.client.HttpClient;
import org.apache.xpath.operations.String;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class AllServices extends JUnit4CitrusTestRunner {

    @Autowired
    HttpClient generalClient;

    String name;
    String price;
    String stock;
    int id;
    String payloadId;


    // Senaryo 1 -- Hiç meyve yok(başlangıç)
    @Test
    @CitrusTest
    public void getAllFruits() {
        http(httpActionBuilder -> httpActionBuilder.client(generalClient)// istek atılacak base url
                .send()
                .get("api/allGrocery") //endpoint
                .contentType("application/json"));
        http(httpActionBuilder ->
                httpActionBuilder.client(generalClient)
                        .receive()
                        .response()
                        .statusCode(200)
                        .status(HttpStatus.NO_CONTENT));
        echo("List is empty");
        traceVariables();
    }


    // Senaryo 2 -- listeye meyve ekleme requirements(price) kontrol
    @Test
    @CitrusTest
    public void checkPriceRequirementsTest() {
        http(httpActionBuilder -> httpActionBuilder.client(generalClient)
                .send()
                .post("/api/grocery/add") //endpoint
                .payload("name=${name}"));
        http(httpActionBuilder ->
                httpActionBuilder.client(generalClient)
                        .receive()
                        .response()
                        .statusCode(400));
        traceVariables();
        echo("Required price");
    }


    // Senaryo 3 -- listeye meyve ekleme requirements value kontrol
    @Test
    @CitrusTest
    public void checkRequirementsFieldsTest() {
        http(httpActionBuilder -> httpActionBuilder.client(generalClient)
                .send()
                .post("/api/grocery/add") //endpoint
                .payload("name=${}&price=${}"));
        http(httpActionBuilder ->
                httpActionBuilder.client(generalClient)
                        .receive()
                        .response()
                        .statusCode(400));
        traceVariables();
        echo("'Name' and 'Price' fields cannot be empty");
    }


    // Senaryo 4 -- listeye meyve ekleme (yeni meyve)
    @Test
    @CitrusTest
    public void addNewFruit() {
        http(httpActionBuilder -> httpActionBuilder.client(generalClient)
                .send()
                .post("/api/grocery/add") //endpoint
                .payload("name=${name}&price=${price}&stock=${stock}"));
        http(httpActionBuilder ->
                httpActionBuilder.client(generalClient)
                        .receive()
                        .response()
                        .statusCode(200)
                        .extractFromPayload("$.Id", payloadId)
                        .extractFromPayload("$.name", name)
                        .extractFromPayload("$.price", price)
                        .extractFromPayload("$.stock", stock));

        traceVariables();

    }


    // Senaryo 5 -- seçili meyveyi getirme
    @Test
    @CitrusTest
    public void getSelectedFruit() {
        http(httpActionBuilder -> httpActionBuilder.client(generalClient)// istek atılacak base url
                .send()
                .get("/api/grocery/"+name)); // üstteki servisten alınan name ile istek gönderiliyor
        http(httpActionBuilder ->
                httpActionBuilder.client(generalClient)
                        .receive()
                        .response()
                        .statusCode(200)
                        .status(HttpStatus.FOUND)
                        .validate("${price}", "price" ));
        echo("found");
        traceVariables();
    }


    // Senaryo 6 -- seçili meyveyi getirme -- listede bulunmayan id
    @Test
    @CitrusTest
    public void getSelectedNotExistFruit() {
        http(httpActionBuilder -> httpActionBuilder.client(generalClient)// istek atılacak base url
                .send()
                .get("/api/grocery/id")); //endpoint
        http(httpActionBuilder ->
                httpActionBuilder.client(generalClient)
                        .receive()
                        .response()
                        .statusCode(404)
                        .status(HttpStatus.NOT_FOUND));
        echo("Fruit is not exist");
        traceVariables();
    }


    // Senaryo 7 -- var olan bir meyveyi ekleme
    @Test
    @CitrusTest
    public void addDublicateFruit() {
        http(httpActionBuilder -> httpActionBuilder.client(generalClient)// istek atılacak base url
                .send()
                .put("/api/grocery/add") //endpoint
                .payload("{ \"name\": \"${name}\", \"price\": \"${price})"));
        http(httpActionBuilder ->
                httpActionBuilder.client(generalClient)
                        .receive()
                        .response().reasonPhrase("duplicate fruit name")
                        .statusCode(400));
        traceVariables();
    }
}

package com.css.opdpatient.jsonparserdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by nishi on 29-1-18(Monday)
 * description: Json parsing
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private TextView txtDisplayParseData;


    private String json1 = "{  \"title\": \"json-examople\" }";
    private String json2 = "\n" +
            "{ \"name\":\"Employee\", \"age\":24, \"emp_id\":\"123\" }\n";
    private String json3 = "\n" +
            "{ \"id\": 1, \"title\": \"json-server\", \"author\": \"typicode\" }\n" +
            "\n";
    private String json4 = "[{\n" +
            "  \"data\": \"data1\",\n" +
            "  \"app_name\": \"Zamit\"\n" +
            "}]\n";

    private String json5 = "[{\n" +
            "  \"animal_id\": \"875f2504-6987-4b07-803e-34d66c2ccb89\",\n" +
            "  \"animal_name\": \"Physignathus cocincinus\"\n" +
            "}, {\n" +
            "  \"animal_id\": \"a29d6990-f89b-4ff3-b9bb-cb55e7a96f6e\",\n" +
            "  \"animal_name\": \"Threskionis aethiopicus\"\n" +
            "}, {\n" +
            "  \"animal_id\": \"f5c2e642-73d1-4b4b-83fe-b7888cf3bfc7\",\n" +
            "  \"animal_name\": \"Heloderma horridum\"\n" +
            "}]\n";

    String parse5 = "", parse55 = "";

    private String json6 = "{\n" +
            "  \"kind\": \"youtube#searchListResponse\",\n" +
            "  \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"\",\n" +
            "  \"nextPageToken\": \"CAUQAA\",\n" +
            "  \"regionCode\": \"KE\",\n" +
            "  \"pageInfo\": {\n" +
            "    \"totalResults\": 4249,\n" +
            "    \"resultsPerPage\": 5\n" +
            "  }\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n";

    private String json7 = "{\n" +
            "  \"checked\": false,\n" +
            "  \"dimensions\": {\n" +
            "    \"width\": 5,\n" +
            "    \"height\": 10\n" +
            "  },\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"A green door\",\n" +
            "  \"price\": 12.5,\n" +
            "  \"tags\": [\n" +
            "    \"home\",\n" +
            "    \"green\"\n" +
            "  ]\n" +
            "}\n";

    private String json8 = "{\n" +
            "\n" +
            "  \"version\": 3.1,\n" +
            "\n" +
            "  \"demo\": true,\n" +
            "  \"person\": {\n" +
            "    \"id\": 12345,\n" +
            "    \"name\": \"John Doe\",\n" +
            "    \"phones\": {\n" +
            "      \"home\": \"800-123-4567\",\n" +
            "      \"mobile\": \"877-123-1234\"\n" +
            "    }\n" +
            "   \n" +
            "   \n" +
            "   \n" +
            "  }\n" +
            "}";

    private String json9 = "{\n" +
            "  \"product\": \"Live JSON generator\",\n" +
            " \n" +
            "  \"person\": {\n" +
            "    \"id\": 12345,\n" +
            "    \"name\": \"John Doe\",\n" +
            "    \n" +
            "    \"email\": [\n" +
            "      \"jd@example.com\",\n" +
            "      \"jd@example.org\"\n" +
            "    ],\n" +
            "    \"dateOfBirth\": \"1980-01-02T00:00:00.000Z\",\n" +
            "    \"registered\": true\n" +
            "  }\n" +
            "}";

    private String json10 = "[\n" +
            "  {\n" +
            "   \n" +
            "    \"timeToLive\": \"2016-04-17T17:23:01Z\",\n" +
            "    \"modeName\": \"bus\"\n" +
            "  },\n" +
            "  {\n" +
            "    \n" +
            "    \"lineId\": \"25\",\n" +
            "    \"lineName\": \"25\",\n" +
            "    \"platformName\": \"B\",\n" +
            "    \"direction\": \"inbound\",\n" +
            "    \"bearing\": \"245\",\n" +
            "    \"destinationNaptanId\": \"\",\n" +
            "    \"destinationName\": \"Oxford Circus\",\n" +
            "    \"timestamp\": \"2016-04-17T16:56:56.463Z\",\n" +
            "    \"timeToStation\": \"1159\"\n" +
            "  \n" +
            "   \n" +
            "  },\n" +
            "  {\n" +
            "    \"type\": \"Tfl.Api.Presentation.Entities.Prediction, Tfl.Api.Presentation.Entities\",\n" +
            "    \"id\": \"733078946\",\n" +
            "    \"operationType\": \"1\",\n" +
            "    \"vehicleId\": \"BJ11DVG\"\n" +
            "    \n" +
            "  }\n" +
            "]\n";

    private String json11 = "{\"rows\":[{\"Item\":2,\"Odd or Even\":\"number 2 is even\",\"Multiplication\":[4,6]},{\"Item\":5,\"Odd or Even\":\"number 5 is odd\"},{\"Item\":6,\"Odd or Even\":\"number 6 is even\"}]}";
    private String json12 = "[{\"first_name\":\"Monica\",\"last_name\":\"Boyer\",\"email_add\":\"Monica.Boyer@vernon.net\",\"address\":\"632 Bonita Springs\",\"created\":\"December 25, 2008\",\"balance\":\"$482.35\"},{\"first_name\":\"Felipa\",\"last_name\":\"Von\",\"email_add\":\"purplerabbit61@gmail.com\",\"address\":\"944 Thompson Bypass\",\"created\":\"July 6, 2010\",\"balance\":\"$272.00\"},{\"first_name\":\"Lorenz\",\"last_name\":\"Green\",\"email_add\":\"Lorenz.Green@aurelio.name\",\"address\":\"3267 Myrtice Creek\",\"created\":\"July 21, 2012\",\"balance\":\"$4,805.03\"},{\"first_name\":\"Hayden\",\"last_name\":\"Simonis\",\"email_add\":\"Hayden.Simonis@adela.org\",\"address\":\"12533 Breana Tunnel\",\"created\":\"April 4, 2017\",\"balance\":\"$8,013.06\"},{\"first_name\":\"Bailee\",\"last_name\":\"Hettinger\",\"email_add\":\"Bailee.Hettinger@gudrun.biz\",\"address\":\"451 Reichel Plaza\",\"created\":\"February 17, 2012\",\"balance\":\"$8,032.72\"},{\"first_name\":\"Jaclyn\",\"last_name\":\"Crist\",\"email_add\":\"Jaclyn.Crist@amie.com\",\"address\":\"85834 Zackary Road\",\"created\":\"September 28, 2013\",\"balance\":\"$925.25\"}]\n" +
            "Json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplayParseData = (TextView) findViewById(R.id.txtDisplayParseData);

        // txtDisplayParseData.setText("json1");

        // JsonParser1();
        //JsonParser2();
        //JsonParser3();
        //JsonParser4();
        //JsonParser5();
        //JsonParser6();
        //JsonParser7();
        //JsonParser8();
        //JsonParser9();
        //JsonParser10();
        //JsonParser11();
        JsonParser12();
    }

    void JsonParser1() {
        try {
            JSONObject jsonObject = new JSONObject(json1);
            txtDisplayParseData.append("title:" + jsonObject.optString("title"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void JsonParser2() {
        try {
            JSONObject jsonObject = new JSONObject(json2);
            txtDisplayParseData.append("name:" + jsonObject.optString("name") + "\n");
            txtDisplayParseData.append("age:" + jsonObject.optString("age") + "\n");
            txtDisplayParseData.append("emp_id:" + jsonObject.optString("emp_id") + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser3() {
        try {

            JSONObject jsonObject = new JSONObject(json3);
            txtDisplayParseData.append("id:" + jsonObject.optString("id") + "\n");
            txtDisplayParseData.append("title:" + jsonObject.optString("title") + "\n");
            txtDisplayParseData.append("author:" + jsonObject.optString("author") + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser4() {
        try {
            JSONArray jsonArray = new JSONArray(json4);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                txtDisplayParseData.append("data:" + jsonObject.optString("data") + "\n");
                txtDisplayParseData.append("app_name:" + jsonObject.optString("app_name") + "\n");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser5() {
        try {
            JSONArray jsonArray = new JSONArray(json5);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.optJSONObject(i);
                txtDisplayParseData.append("animal_id:" + jsonObject.optString("animal_id") + "\n");
                txtDisplayParseData.append("animal_name:" + jsonObject.optString("animal_name") + "\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser6() {
        try {


            JSONObject jsonObject = new JSONObject(json6);
            txtDisplayParseData.append("kind:" + jsonObject.optString("kind") + "\n");
            txtDisplayParseData.append("etag:" + jsonObject.optString("etag") + "\n");
            txtDisplayParseData.append("nextPageToken:" + jsonObject.optString("nextPageToken") + "\n");
            txtDisplayParseData.append("totalResults:" + jsonObject.optString("totalResults") + "\n");
            txtDisplayParseData.append("resultsPerPage:" + jsonObject.optString("resultsPerPage") + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser7() {
        try {


            JSONObject jsonObject = new JSONObject(json7);
            txtDisplayParseData.append("checked:" + jsonObject.optString("checked") + "\n");
            txtDisplayParseData.append("dimensions:" + jsonObject.optString("dimensions") + "\n");
            txtDisplayParseData.append("id:" + jsonObject.optString("id") + "\n");
            txtDisplayParseData.append("name:" + jsonObject.optString("name") + "\n");
            txtDisplayParseData.append("price:" + jsonObject.optString("price") + "\n");
            txtDisplayParseData.append("tags:" + jsonObject.optString("tags") + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser8() {
        try {


            JSONObject jsonObject = new JSONObject(json8);
            txtDisplayParseData.append("version:" + jsonObject.optString("version") + "\n");
            txtDisplayParseData.append("demo:" + jsonObject.optString("demo") + "\n");
            txtDisplayParseData.append("person:" + jsonObject.optString("person") + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser9() {
        try {


            JSONObject jsonObject = new JSONObject(json9);
            txtDisplayParseData.append("product:" + jsonObject.optString("product") + "\n");
            JSONArray jsonArray = new JSONArray(json11);


            txtDisplayParseData.append("id:" + jsonObject.optString("id") + "\n");
            txtDisplayParseData.append("name" + jsonObject.optString("name") + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser10() {
        try {
            JSONArray jsonArray = new JSONArray(json10);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);

                txtDisplayParseData.append("timeToLive:" + jsonObject.optString("timeToLive") + "\n");
                txtDisplayParseData.append("modeName:" + jsonObject.optString("modeName") + "\n");

                txtDisplayParseData.append("lineId:" + jsonObject.optString("lineId") + "\n");
                txtDisplayParseData.append("lineName:" + jsonObject.optString("lineName") + "\n");
                txtDisplayParseData.append("platformName:" + jsonObject.optString("platformName") + "\n");
                txtDisplayParseData.append("direction:" + jsonObject.optString("direction") + "\n");
                txtDisplayParseData.append("bearing:" + jsonObject.optString("bearing") + "\n");
                txtDisplayParseData.append("destinationNaptanId:" + jsonObject.optString("destinationNaptanId") + "\n");
                txtDisplayParseData.append("destinationName:" + jsonObject.optString("destinationName") + "\n");
                txtDisplayParseData.append("timestamp:" + jsonObject.optString("timestamp") + "\n");
                txtDisplayParseData.append("timeToStation:" + jsonObject.optString("timeToStation") + "\n");

                txtDisplayParseData.append("currentLocation:" + jsonObject.optString("currentLocation") + "\n");
                txtDisplayParseData.append("type:" + jsonObject.optString("type") + "\n");
                txtDisplayParseData.append("id:" + jsonObject.optString("id") + "\n");
                txtDisplayParseData.append("operationType:" + jsonObject.optString("operationType") + "\n");
                txtDisplayParseData.append("vehicleId:" + jsonObject.optString("vehicleId") + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser11() {
        try {

            JSONArray jsonArray = new JSONArray(json11);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);

                txtDisplayParseData.append("item:" + jsonObject.optString("item") + "\n");
                txtDisplayParseData.append("Odd or Even:" + jsonObject.optString("Odd or Even") + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void JsonParser12() {
        try {
            JSONArray jsonArray = new JSONArray(json12);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.optJSONObject(i);
                txtDisplayParseData.append("first_name:" + jsonObject.optString("first_name") + "\n" + "\n");
                txtDisplayParseData.append("last_name:" + jsonObject.optString("last_name") + "\n" + "\n");
                txtDisplayParseData.append("email_add:" + jsonObject.optString("email_add") + "\n" + "\n");
                txtDisplayParseData.append("address:" + jsonObject.optString("address") + "\n" + "\n");
                txtDisplayParseData.append("created:" + jsonObject.optString("created") + "\n" + "\n");
                txtDisplayParseData.append("balance:" + jsonObject.optString("balance") + "\n" + "\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}// end of oncreate()

package fri.uniza.sk.weatherclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.zetterstrom.com.forecast.ForecastClient;
import android.zetterstrom.com.forecast.ForecastConfiguration;
import android.zetterstrom.com.forecast.models.Forecast;
import android.zetterstrom.com.forecast.models.Language;
import android.zetterstrom.com.forecast.models.Unit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "c8a2f40cf25fcd255e0f47e637a2cde8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ForecastConfiguration configuration =
                new ForecastConfiguration.Builder(API_KEY)
                        .setCacheDirectory(getCacheDir())
                        .build();
        ForecastClient.create(configuration);

        double latitude = 49.201916;
        double longitude =18.761655;
        final ForecastClient forecastClient = ForecastClient.getInstance();
        forecastClient.getForecast(latitude, longitude, null, Language.SLOVAK, Unit.SI, null, false, new Callback<Forecast>() {
            //forecastClient.getForecast(latitude, longitude, new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> forecastCall, Response<Forecast> response) {
                if (response.isSuccessful()) {
                    Forecast forecast = response.body();
                    forecast.toString();
                }
            }

            @Override
            public void onFailure(Call<Forecast> forecastCall, Throwable t) {

            }
        });
    }
}

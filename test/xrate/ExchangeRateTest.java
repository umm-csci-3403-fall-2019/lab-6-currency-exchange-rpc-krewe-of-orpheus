package xrate;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExchangeRateTest {
    private static final String NICS_DUMMY_DATA_URL = "http://facultypages.morris.umn.edu/~mcphee/ExchangeRateData/";
    private static final double DELTA = 0.0001;

    @Test
    public void checkUSD20091112() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader(NICS_DUMMY_DATA_URL);
        float rate = xrReader.getExchangeRate("USD", 2009, 11, 12);
        assertEquals(1.485674, rate, DELTA);
    }

    @Test
    public void checkGBP20100625() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader(NICS_DUMMY_DATA_URL);
        float rate = xrReader.getExchangeRate("GBP", 2010, 6, 25);
        assertEquals(0.823961, rate, DELTA);
    }

    @Test
    public void checkCHF20100705() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader(NICS_DUMMY_DATA_URL);
        float rate = xrReader.getExchangeRate("CHF", 2010, 7, 5);
        assertEquals(1.333588, rate, DELTA);
    }

    @Test
    public void checkZAR20100909() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader(NICS_DUMMY_DATA_URL);
        float rate = xrReader.getExchangeRate("ZAR", 2010, 9, 9);
        assertEquals(9.165675, rate, DELTA);
    }
    
    @Test
    public void checkUSDvsGBP20100625() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader(NICS_DUMMY_DATA_URL);
        float rate = xrReader.getExchangeRate("USD", "GBP", 2010, 6, 25);
        assertEquals(1.4986571073532104, rate, DELTA);
    }

    // TO GET THIS TEST TO RUN YOU NEED TO ADD A VALID ACCESS KEY IN THE URL
    @Test
    public void checkUSDvsGBP20100625online() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader("http://data.fixer.io/api/");
        float rate = xrReader.getExchangeRate("USD", "GBP", 2010, 6, 25);
        assertEquals(1.4986571073532104, rate, DELTA);
    }

    @Test
    public void checkEURvsGBP20191029online() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader("http://data.fixer.io/api/");
        float rate = xrReader.getExchangeRate("EUR", "GBP", 2019, 10, 29);
        assertEquals(0.862018, rate, DELTA);
    }

    @Test
    public void checkGBPvsEUR20191029online() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader("http://data.fixer.io/api/");
        float rate = xrReader.getExchangeRate("GBP", "EUR", 2019, 10, 29);
        assertEquals(1/0.862018, rate, DELTA);
    }

    @Test
    public void checkGBPvsGBP20191029online() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader("http://data.fixer.io/api/");
        float rate = xrReader.getExchangeRate("GBP", "GBP", 2019, 10, 29);
        assertEquals(1, rate, DELTA);
    }

    @Test
    public void checkEURvsEUR20191029online() throws IOException {
        ExchangeRateReader xrReader = new ExchangeRateReader("http://data.fixer.io/api/");
        float rate = xrReader.getExchangeRate("EUR", "EUR", 2019, 10, 29);
        assertEquals(1, rate, DELTA);
    }
}

# How to run
./gradlew bootRun

## Usage

```
curl --request POST \
  --url http://localhost:8080/currency/convert \
  --header 'content-type: application/json' \
  --data '{
	"from":"USD",
	"to":"BRL",
	"amount":10
}```

Possible currencies: EUR, AED, ARS, AUD, BGN, BRL, BSD, CAD, CHF, CLP, CNY, COP, CZK, DKK, DOP, EGP, FJD, GBP, GTQ, HKD, 
HRK, HUF, IDR, ILS, INR, ISK, JPY, KRW, KZT, MVR, MXN, MYR, NOK, NZD, PAB, PEN, PHP, PKR, PLN, PYG, RON, RUB, SAR, SEK, 
SGD, THB, TRY, TWD, UAH, USD, UYU, ZAR

## Tests
Run ./gradlew test when netty server is running
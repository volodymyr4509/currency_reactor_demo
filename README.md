## Prerequisites
java 11
## How to run
```
./gradlew bootRun
```

## Usage

```
curl --request POST \
  --url http://localhost:8080/currency/convert \
  --header 'content-type: application/json' \
  --data '{
	"from":"USD",
	"to":"BRL",
	"amount":10
}
```

## Possible currencies for request body: 
CAD, HKD, ISK, PHP, DKK, HUF, CZK, AUD, RON, SEK, IDR, INR, BRL, RUB, HRK, JPY, THB, CHF, SGD, PLN, BGN, TRY, CNY, NOK, NZD, ZAR, USD, MXN, ILS, GBP, KRW, MYR

## Tests
Run below command when application server is running on localhost:8080
```
./gradlew test
```

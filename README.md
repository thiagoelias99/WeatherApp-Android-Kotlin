# WeatherApp-Android-Kotlin
 App desenvolvido como projeto do curso de introdução a desenvolvimento de aplicativos móveis para Android com Kotlin.

 ## Api para consulta
 ### Procura de cidade
 - <https://brasilapi.com.br/api/cptec/v1/cidade/{cityName}>
 ### Previsão
 - <https://brasilapi.com.br/api/cptec/v1/clima/previsao/{cityCode}>

## Todo
- Recicler Cidade - OK
- Rooms Cidade - OK
- Recicler Principal
- Get Clima
- Tela add Cidade
- Tela Cidade List
- Tela Cidade Detail
- Room notas
- Tela Login
- Tela Cadastro
- Room Users
- Prefs
- Recicler Principal User

## Models
### City
{
    "code": "Int" (PK),
    "name": "String",
    "state": "String"
    "updatedAt": "Date",
    "date": "Date",
    "conditionCode": "String",
    "conditionDescription": "String",
    "minTemperature": "Int",
    "maxTemperature": "Int",
    "uvIndex": "Int"
}
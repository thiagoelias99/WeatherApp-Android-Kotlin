package com.puc.telias.weatherapp.webclient.Models

import java.util.Date

class WeatherForecast(
    codigo: String? = null,
    estado: String? = null,
    atualizado_em: String? = null,
    clima: Array<Weather>? = null
)

class Weather(
    data: String? = null,
    condicao: String? = null,
    condicao_desc: String? = null,
    min: Int? = null,
    max: Int? = null,
    indice_uv: Int? = null
)
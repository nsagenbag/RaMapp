package com.e.ramapp.data.dto

import com.google.gson.annotations.SerializedName

/*
{
  "info": {
    "count": 671,
    "pages": 34,
    "next": "https://rickandmortyapi.com/api/character/?page=2",
    "prev": null
  },
  "results": [
    {
      "id": 1,
      "name": "Rick Sanchez",
      "status": "Alive",
      "species": "Human",
      "type": "",
      "gender": "Male",
      "origin": {
        "name": "Earth",
        "url": "https://rickandmortyapi.com/api/location/1"
      },
      "location": {
        "name": "Earth",
        "url": "https://rickandmortyapi.com/api/location/20"
      },
      "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
      "episode": [
        "https://rickandmortyapi.com/api/episode/1",
        "https://rickandmortyapi.com/api/episode/2",
        // ...
      ],
      "url": "https://rickandmortyapi.com/api/character/1",
      "created": "2017-11-04T18:48:46.250Z"
    },
    // ...
  ]
}
 */

data class AllCharactersDto(
    @SerializedName( "info")
    val info: Info,

    @SerializedName( "results")
    val results: List<PayloadResults>
)
{
    data class Info(
        @SerializedName( "count")
        val count: Long?,

        @SerializedName( "pages")
        val pages: Long?,

        @SerializedName( "next")
        val next: String?,

        @SerializedName( "prev")
        val prev: Any?
    )
    data class PayloadResults(
        @SerializedName( "id")
        val id: Long?,

        @SerializedName( "name")
        val name: String?
    )
}
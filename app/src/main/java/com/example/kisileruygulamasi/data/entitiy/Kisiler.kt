package com.example.kisileruygulamasi.data.entitiy

import java.io.Serializable


// it is a data class that is used to store the data of the people in the application.
data class Kisiler (var kisi_id: Int ,
                    var kisi_ad : String ,
                    var kisi_tel : String) : Serializable {
}

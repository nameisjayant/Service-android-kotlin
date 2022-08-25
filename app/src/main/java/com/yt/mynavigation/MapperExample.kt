package com.yt.mynavigation

data class ProfileDto(
    val name:String,
    val email:String
)

data class ProfileEntity(
    val name:String,
    val email:String,
    val address:String,
    val phone:String
){
    fun dto():ProfileDto{
        return ProfileDto(
            name = this.name,
            email = this.email
        )
    }
}


class ProfileDto2(profileEntity: ProfileEntity){
    var name = profileEntity.name
    var email = profileEntity.email
}

class ProfileDto3(profileEntity: ProfileEntity){
    val name by profileEntity :: name
    val email by profileEntity :: email
}

fun ProfileEntity.delegateDto() = ProfileDto3(this)


fun ProfileEntity.todo() = ProfileDto2(this)
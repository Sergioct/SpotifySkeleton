package com.sergiocrespotoubes.domain.mapper

interface Mapper<SomeDto, SomeDomainModel> {
    fun toDomainModel(value: SomeDto): SomeDomainModel

    fun toDto(value: SomeDomainModel): SomeDto

    fun toDomainModel(values: List<SomeDto>): List<SomeDomainModel> = values.map { toDomainModel(it) }

    fun toDto(values: List<SomeDomainModel>): List<SomeDto> = values.map { toDto(it) }
}

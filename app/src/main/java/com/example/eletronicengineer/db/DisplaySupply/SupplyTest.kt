package com.example.eletronicengineer.distributionFileSave

import java.io.Serializable

class SupplyTest(
    var id:String,
    var vipId:String,
    var name:String,
    var isCar:String,
    var isConstructionTool:String,
    var operateDegree:String,
    var foundTime:String,
    var founder:String,
    var alterTime:String,
    var alterPeople:String,
    var delFlag:String,
    var version:String,
    var teamServeId:String,
    var validTime:String,
    var issuerBelongSite:String,
    var provideCrewLists:List<ProvideCrewLists>?,
    var provideTransportMachines:List<ProvideTransportMachines>?,
    var constructionToolLists:List<ConstructionToolLists>?,
    var voltages:List<Voltages>?,
    var testWorkTypes:String
):Serializable
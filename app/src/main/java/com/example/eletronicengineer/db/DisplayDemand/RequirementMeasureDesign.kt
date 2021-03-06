package com.example.eletronicengineer.distributionFileSave

import com.example.eletronicengineer.db.DisplayDemand.RequirementCarList
import com.example.eletronicengineer.db.DisplayDemand.RequirementMembersList
import java.io.Serializable

class RequirementMeasureDesign(
    var id:String,
    var vipId:String,
    var requirementType:String,
    var requirementVariety:String,
    var projectName:String,
    var projectSite:String,
    var projectTime:String,
    var workerExperience:String,
    var minAgeDemand:String,
    var maxAgeDemand:String,
    var sexDemand:String,
    var roomBoardStandard:String,
    var journeyCarFare:String,
    var journeySalary:String,
    var needPeopleNumber:String,
    var salaryStandard:String,
    var vehicle:String,
    var equipment:String,
    var additonalDxplain:String,
    var name:String,
    var phone:String,
    var foundTime:String,
    var founder:String,
    var alterTime:String,
    var alterPeople:String,
    var delFlag:String,
    var version:String,
    var requirmentTeamServeId:String,
    var requirementCarLists:List<RequirementCarList>?,
    var requirementMembersLists:List<RequirementMembersList>?,
    var requirementTeamProjectList:List<requirementTeamProjectList>?,
    var requirementPowerTransformationSalary:List<requirementPowerTransformationSalary>?,
    var requirementListQuotations:List<requirementTeamProjectList>?,
    var requirementConstructionWorkKind:String,
    var requirementTeamVoltageClasses:String,
    var photoPath:String,
    var validTime:String
): Serializable
package com.example.eletronicengineer.fragment.retailstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eletronicengineer.R
import com.example.eletronicengineer.adapter.RecyclerviewAdapter
import com.example.eletronicengineer.utils.*
import com.example.eletronicengineer.utils.getRequirementPerson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_demand_display.view.*

class DemandDisplayFragment:Fragment() {
    companion object{
        fun newInstance(args: Bundle): DemandDisplayFragment
        {
            val fragment= DemandDisplayFragment()
            fragment.arguments=args
            return fragment
        }
    }
    lateinit var title:String
    var type:Int=1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_demand_display, container, false)
        title=arguments!!.getString("title")
        type = arguments!!.getInt("type")
        view.tv_display_demand_title.text=title
        initFragment(view)
        return view
    }

    private fun initFragment(view: View) {
        view.tv_display_demand_back.setOnClickListener {
            activity!!.finish()
        }

        val adapterGenerate = AdapterGenerate()
        adapterGenerate.context = view.context
        adapterGenerate.activity = activity as AppCompatActivity
        lateinit var adapter: RecyclerviewAdapter
        when (type) {
            1 -> {
                adapter = adapterGenerate.demandIndividualDisplay()
                val result = getRequirementPerson(1,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZWRpc0tleSI6InVwbXM6bG9naW46MTY1RTFBNTYyREY2MTFGQzY3M0I3OEUyMkM1NjZBNDIiLCJpZCI6IjExNjg0MzE0Njk4OTEzMzQxNDQiLCJleHAiOjE1Njc2OTExMTQsInVzZXJuYW1lIjoiMTgzNzM4NDE5NTMifQ.sXBwtOldbFcH7fdsbYZNEHk44x1sWwvoqlzgW7f1Ae8","http://192.168.1.132:8012/")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe ({
                        for(j in it.data)
                        {
                            adapter.mData[0].singleDisplayRightContent=if(j.requirementVariety==null) {
                                "无" } else{ j.requirementVariety }
                            adapter.mData[1].singleDisplayRightContent=if(j.requirementMajor==null) {
                                "无" } else{ j.requirementMajor }
                                adapter.mData[2].singleDisplayRightContent=if(j.projectName==null) {
                                    "无" } else{ j.projectName}
                                adapter.mData[3].singleDisplayRightContent=if(j.projectSite==null) {
                                    "无" } else{ j.projectSite}
                                adapter.mData[4].singleDisplayRightContent=if(j.planTime==null) {
                                    "无" } else{ j.planTime}
                                adapter.mData[5].singleDisplayRightContent=if(j.workerExperience==null) {
                                    "无" } else{ j.workerExperience}
                                adapter.mData[6].singleDisplayRightContent=if(j.minAgeDemand==null||j.maxAgeDemand==null) {
                                    "无" } else{  "${j.minAgeDemand}~${j.maxAgeDemand}"}
                                if(j.sexDemand=="0") {
                                    adapter.mData[7].singleDisplayRightContent="女" }
                                else if(j.sexDemand=="1"){ adapter.mData[7].singleDisplayRightContent="男"}
                                else if(j.sexDemand=="-1"){adapter.mData[7].singleDisplayRightContent="男女不限"}
                                else{ }
                                adapter.mData[8].singleDisplayRightContent=if(j.roomBoardStandard=="0") {
                                    "无" } else{ j.roomBoardStandard}
                                if(j.roomBoardStandard=="0") {
                                 adapter.mData[8].singleDisplayRightContent="队部自理" }
                                else if(j.roomBoardStandard=="1"){ adapter.mData[8].singleDisplayRightContent="全包"}
                                else{ }
                                adapter.mData[9].singleDisplayRightContent=if(j.journeySalary==null) {
                                    "无" } else{ j.journeySalary}
                                adapter.mData[10].singleDisplayRightContent=if(j.journeyCarFare==null) {
                                    "无" } else{ j.journeyCarFare}
                                adapter.mData[11].singleDisplayRightContent=if(j.needPeopleNumber==null) {
                                    "无" } else{ j.needPeopleNumber}
                                adapter.mData[12].singleDisplayRightContent=if(j.salaryStandard==null) {
                                    "无" } else{ j.salaryStandard.toString()}
                                adapter.mData[14].singleDisplayRightContent=if(j.name==null) {
                                    "无" } else{ j.name}
                                adapter.mData[15].singleDisplayRightContent=if(j.phone==null) {
                                    "无" } else{ j.phone}
                                adapter.mData[16].singleDisplayRightContent=if(j.validTime==null) {
                                    "无" } else{ j.validTime}
                                adapter.mData[17].singleDisplayRightContent=if(j.additonalExplain==null) {
                                    "无" } else{ j.additonalExplain}

                            view.tv_fragment_demand_display_content.adapter = adapter
                            view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
                        }
                    },{
                        it.printStackTrace()
                    })
            }
            2->{
                adapter = adapterGenerate.demandTeamDisplay()
//                val result = getRequirementMajorNetWork(1,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZWRpc0tleSI6InVwbXM6bG9naW46OTExNDFCNEU0QzgxOTFBRTdCNkNEQzQ2QzlGNjZGMDEiLCJpZCI6IjExNzA2MDMxMTMwNDE2MTI4MDAiLCJleHAiOjE1Njc5OTkwNDQsInVzZXJuYW1lIjoiMTM1NzUyMzI1MzEifQ.1PSXdgJwVu-mcgJAtvvutwUBfsigRCWiCNhd504OjLs","http://192.168.1.132:8012/")
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread()).subscribe ({
//                        for(j in it.data)
//                        {
//                            adapter.mData[0].singleDisplayRightContent=if(j.requirementVariety==null) {
//                                "无" } else{ j.requirementVariety }
//                            adapter.mData[1].singleDisplayRightContent=if(j.projectName==null) {
//                                "无" } else{ j.projectName }
//                            adapter.mData[2].singleDisplayRightContent=if(j.projectSite==null) {
//                                "无" } else{ j.projectSite}
//                            adapter.mData[3].singleDisplayRightContent=if(j.projectTime==null) {
//                                "无" } else{ j.projectTime}
//                            adapter.mData[5].singleDisplayRightContent=if(j.requirementTeamVoltageClasses==null) {
//                                "无" } else{ j.requirementTeamVoltageClasses}
//                            adapter.mData[6].singleDisplayRightContent=if(j.requirementConstructionWorkKind==null) {
//                                "无" } else{ j.requirementConstructionWorkKind}
//                            adapter.mData[7].singleDisplayRightContent=if(j.workerExperience==null) {
//                                "无" } else{ j.workerExperience}
//                            adapter.mData[8].singleDisplayRightContent=if(j.minAgeDemand==null||j.maxAgeDemand==null) {
//                                "无" } else{  "${j.minAgeDemand}~${j.maxAgeDemand}"}
//                            adapter.mData[9].singleDisplayRightContent=if(j.sexDemand==null) {
//                                "无" } else{ j.sexDemand}
//                            adapter.mData[10].singleDisplayRightContent=if(j.roomBoardStandard==null) {
//                                "无" } else{ j.roomBoardStandard}
//                            adapter.mData[12].singleDisplayRightContent=if(j.journeySalary==null) {
//                                "无" } else{ j.journeySalary}
//                            adapter.mData[11].singleDisplayRightContent=if(j.journeyCarFare==null) {
//                                "无" } else{ j.journeyCarFare}
//                            adapter.mData[13].singleDisplayRightContent=if(j.needPeopleNumber==null) {
//                                "无" } else{ j.needPeopleNumber}
//                            adapter.mData[14].singleDisplayRightContent=if(j.salaryStandard==null) {
//                                "无" } else{ j.salaryStandard}
//                            adapter.mData[15].singleDisplayRightContent=if(j.vehicle==null) {
//                                "无" } else{ j.vehicle}
//                            adapter.mData[16].singleDisplayRightContent=if(j.constructionEquipment==null) {
//                                "无" } else{ j.constructionEquipment}
//                            adapter.mData[18].singleDisplayRightContent=if(j.name==null) {
//                                "无" } else{ j.name}
//                            adapter.mData[19].singleDisplayRightContent=if(j.phone==null) {
//                                "无" } else{ j.phone}
//                            adapter.mData[20].singleDisplayRightContent=if(j.validTime==null) {
//                                "无" } else{ j.validTime}
//                            adapter.mData[20].singleDisplayRightContent=if(j.additonalExplain==null) {
//                                "无" } else{ j.additonalExplain}
//
//                            view.tv_fragment_demand_display_content.adapter = adapter
//                            view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
//                        }
//                    },{
//                        it.printStackTrace()
//                    })
            }
            3->{
                adapter = adapterGenerate.demandTeamDisplayGongTrans()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            4->{
                adapter = adapterGenerate.demandTeamDisplayPile()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            5->{
                adapter = adapterGenerate.demandTeamDisplayTrenchiless()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            6->{
                adapter = adapterGenerate.demandTeamDisplayTestAndDebugging()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            7->{
                adapter = adapterGenerate.demandTeamDisplayCrossFrame()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            8->{
                adapter = adapterGenerate.demandTeamDisplayOperationAndMaintenance()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            9->{
                adapter = adapterGenerate.demandTeamDisplayVehicleLeasing()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            10->{
                adapter = adapterGenerate.demandTeamDisplayEquipmentLeasing()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }
            11->{
                adapter = adapterGenerate.demandTeamDisplayDemandTripartite()
                view.tv_fragment_demand_display_content.adapter = adapter
                view.tv_fragment_demand_display_content.layoutManager = LinearLayoutManager(view.context)
            }

        }

    }
}
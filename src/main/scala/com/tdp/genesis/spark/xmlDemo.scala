package com.tdp.genesis.spark


import java.text.SimpleDateFormat
import java.util.Date
import org.apache.spark.sql.SparkSession


object xmlDemo {

  private val dateFmt = "yyyy/MM/dd hh:mm:ss a"

  // TIME FUNCTION
  def today(): String = {
    val date = new Date
    val sdf = new SimpleDateFormat(dateFmt)
    sdf.format(date)
  }


  def main(args: Array[String]): Unit = {

    val master = args(0)


    val spark = SparkSession.builder
      .appName("SparkSessionExample")
      .master(master)
      .config("spark.executor.memory", "10g")
      .config("spark.driver.memory", "5g")
      .config("spark.memory.offHeap.enabled", true)
      .config("spark.memory.offHeap.size", "5g")
      .enableHiveSupport()
      .getOrCreate




    //////////////////////////////////////////////////////////////////////////


    println(
      s"""
         |
         | ====================================================================
         | =  Starting   SPARK                                                =
         | =  Proceso:         XML_Demo                                       =
         | =  Log Level:       OFF                                            =
         | =  Fecha de Inicio: ${today()}                         =
         | ====================================================================
         |
         |""".stripMargin)

  }

}

package com.tdp.genesis.spark


import java.text.SimpleDateFormat
import java.util.Date
import org.apache.spark.sql.SparkSession
import com.databricks.spark.xml._


object xmlDemo {

  private val dateFmt = "yyyy/MM/dd hh:mm:ss a"

  // TIME FUNCTION
  def today(): String = {
    val date = new Date
    val sdf = new SimpleDateFormat(dateFmt)
    sdf.format(date)
  }
  println(
    s"""
       |
       | ====================================================================
       | =  Starting   SPARK                                                =
       | =  Proceso:         XML_Demo                                       =
       | =  Log Level:       ON                                            =
       | =  Fecha de Inicio: ${today()}                         =
       | ====================================================================
       |
       |""".stripMargin)


  def main(args: Array[String]): Unit = {

    val master  = args(0)
    val xmlFile = args(1)
    val rowTag  = args(2)
    val executorMemory  = args(3)
    val driverMemory    = args(4)
    val memoryOffHeap   = args(5)

    val spark = SparkSession.builder
      .appName("SparkSessionExample")
      .master(master)
      .config("spark.executor.memory", executorMemory)
      .config("spark.driver.memory", driverMemory)
      .config("spark.memory.offHeap.enabled", true)
      .config("spark.memory.offHeap.size", memoryOffHeap)
      .getOrCreate


    //////////////////////////////////////////////////////////////////////////

    val df = spark.read
      .format("com.databricks.spark.xml")
      .option("rowTag", rowTag)
      .load(xmlFile)

    println("--------------")
    df.show(10 )
    df.printSchema()




  }

}

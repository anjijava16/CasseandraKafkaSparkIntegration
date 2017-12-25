import org.apache.spark.SparkConf

import org.apache.spark.SparkContext
import com.datastax.spark.connector._
import java.sql.Timestamp
import java.util.Date


object Main {


    def main(args: Array[String]): Unit = {
    // only setting app name, all other properties will be specified at runtime for flexibility
    val conf = new SparkConf().set("spark.cassandra.connection.host", "127.0.0.1").setAppName("cassandra-example-hello").setMaster("local[*]");

    val sc = new SparkContext(conf)
    
    
    
    val hello = sc.cassandraTable("simplex", "songs")
    
  //hello.saveAsCassandraTableEx(table, columns, writeConf)
      //hello.toArray.foreach(println)
      
  
  val collection = sc.parallelize(Seq(("cat", 30), ("fox1", 40)))
collection.saveToCassandra("test1", "words", SomeColumns("word", "count"))


  val collection_new = sc.parallelize(Seq(("cat1", 30,new Timestamp(new Date().getTime)),("cat", 30,new Timestamp(new Date().getTime)), ("fox1", 40,new Timestamp(new Date().getTime))))
collection_new.saveToCassandra("test1", "wordsnew", SomeColumns("word", "count","last_modified_date"))



/*userID int primary key ,
userfirstname text,
userlastname text,
useremail text,
usercountry text,
userstate text,
usercity text,
usercreationdate timestamp)
SomeColumns(userID,userfirstname,userlastname,useremail,usercountry,userstate,usercity,usercreationdate);
* 
* */


//test1.wordsnew
      hello.foreach(println);
    
   // println(hello.columnNames+"  "+hello.connector+"  "+hello.collect()+" "+hello.count());
    

    //val hello = sc.cassandraTable[(String, String)]("simplex", "songs")

  /*     val hello = sc.cassandraTable("test", "my_table");

    //val hello = sc.cassandraTable("simplex", "songs")

    val first = hello.first
    
    println("First"+first);

    sc.stop

    println(first)
*/  }
    
   /* val conf = new SparkConf(true)
      .set("spark.cassandra.connection.host", "127.0.0.1")
      .setMaster("local[*]")
      .setAppName("KafkaCassandraTest")

    val sc = new SparkContext(conf);

    sc.
   val test_spark_rdd = sc.cassandraTable("test", "my_table");
   */
   
    /*val spark = SparkSession.builder().
      .set("spark.cassandra.connection.host", "127.0.0.1")
      .setMaster("local[*]")
      .setAppName("KafkaCassandraTest")
*/
  
}
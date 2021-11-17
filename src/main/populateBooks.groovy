package com.manifestcorp.techreads

import groovy.json.JsonSlurper
import groovy.sql.Sql


def feed = new URL("https://www.googleapis.com/books/v1/volumes?q=java").text
def sql = Sql.newInstance(
        "jdbc:mysql://localhost:3306/techreads",'root','root+1',"com.mysql.jdbc.Driver")

def books = new JsonSlurper().parseText(feed)
books.items.each{item ->
    sql.execute("""insert into book(title,cover_url,author,rating) 
     values(${item.volumeInfo.title}, ${item.volumeInfo.imageLinks.smallThumbnail}, 
     ${item.volumeInfo.authors[0]}, ${item.volumeInfo.averageRating});""")
}
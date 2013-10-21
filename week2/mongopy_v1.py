import pymongo
import sys

# establish a connection to the database
connection = pymongo.Connection("mongodb://localhost", safe=True)

# get a handle to the school databse
db=connection.students
grades = db.grades

def find_and_remove():

        query = {'type':'homework'}

        try:
                all_homework = grades.find(query)
                sorted_homework = all_homework.sort([('student_id', pymongo.ASCENDING),('score',pymongo.ASCENDING)])

        except:
                print "Unexpected error:", sys.exc_info()[0]

        sanity = 0
        current_student = 0

        for doc in sorted_homework:
                if doc['student_id'] == current_student:
                        # print doc
                        grades.remove(doc)
                        current_student += 1

find_and_remove()

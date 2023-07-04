from django.db import models

# Create your models here.
class Book(models.Model):
    id=models.AutoField(primary_key=True)
    isbn=models.CharField(max_length=15,null=True)
    bookname=models.CharField(max_length=10,null=True)
    publishertime=models.DateField(null=True)
    picture=models.CharField(max_length=200,null=True)
    sentence=models.CharField(max_length=500,null=True)

class Bookone(models.Model):
    id=models.CharField(max_length=100,primary_key=True)
    isbn=models.CharField(max_length=15,null=True)
    bookname=models.CharField(max_length=10,null=True)
    publishertime=models.CharField(max_length=500,null=True)
    sentence=models.CharField(max_length=500,null=True)

class Booktwo(models.Model):
    id=models.CharField(max_length=100,primary_key=True)
    isbn=models.CharField(max_length=15,null=True)
    bookname=models.CharField(max_length=10,null=True)
    publishertime=models.CharField(max_length=500,null=True)
    sentence=models.CharField(max_length=500,null=True)

class Login(models.Model):
    user=models.CharField(max_length=100,primary_key=True)
    password=models.CharField(max_length=15,null=True)




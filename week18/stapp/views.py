from django.shortcuts import render
from django.http import JsonResponse
from django.http import HttpResponse
from stapp.models import Login
from stapp.models import Book
from stapp.models import Bookone
from stapp.models import Booktwo
from rest_framework import status
from rest_framework.views import APIView
from rest_framework.response import Response
from .serialiazer import StudentModelSerializer
from rest_framework.generics import GenericAPIView

# Create your views here.
def addinfo(request):
    isbn=request.GET["isbn"]
    bookname=request.GET["bookname"]
    publishertime=request.GET["publishertime"]
    sentence=request.GET["sentence"]
    Book.objects.create(isbn=isbn,bookname=bookname,publishertime=publishertime,sentence=sentence)
    return HttpResponse("添加成功")

def deleteinfo(request):
    id = request.GET["id"]
    Book.objects.filter(id=id).delete()
    return HttpResponse("已删除")

def updateinfo(request):
    id = request.GET["id"]
    isbn=request.GET["isbn"]
    bookname=request.GET["bookname"]
    publishertime=request.GET["publishertime"]
    #picture=request.GET["picture"]
    sentence=request.GET["sentence"]
    Book.objects.filter(id=id).update(isbn=isbn,bookname=bookname,publishertime=publishertime,sentence=sentence)
    return HttpResponse("修改完成")

def getinfo(request):
    id=request.GET["id"]
    info=Book.objects.get(id=id)
    list2 = [{
        "id": f"{info.id}",
        "isbn": info.isbn,
        "bookname": info.bookname,
        "publishertime": info.publishertime,
        "picture":info.picture,
        "sentence":info.sentence,
    }]
    return JsonResponse(list2,safe=False)

def testdb(request):
    list = Book.objects.all()
    list3 = []
    for var in list:
        data = {}
        data['id']=f"{var.id}"
        data['isbn']=var.isbn
        data['bookname'] = var.bookname
        data['publishertime'] = var.publishertime
        #data['picture'] = var.picture
        data['sentence'] = var.sentence

        list3.append(data)

    return JsonResponse(list3,safe=False)



def testdbone(request):
    list = Bookone.objects.all()
    list2 = []
    for var in list:
        data = {}
        data['id']=var.id
        data['isbn']=var.isbn
        data['bookname'] = var.bookname
        data['publishertime'] = var.publishertime
        data['sentence'] = var.sentence
        list2.append(data)
    return JsonResponse(list2,safe=False)

def testdbtwo(request):
    list = Booktwo.objects.all()
    list2 = []
    for var in list:
        data = {}
        data['id']=var.id
        data['isbn']=var.isbn
        data['bookname'] = var.bookname
        data['publishertime'] = var.publishertime
        data['sentence'] = var.sentence
        list2.append(data)
    return JsonResponse(list2,safe=False)

def getinfoone(request):
    id=request.GET["id"]
    info=Bookone.objects.get(id=id)
    list2 = [{
        "id":f"{info.id}",
        "isbn": info.isbn,
        "bookname": info.bookname,
        "publishertime": info.publishertime,
        "sentence":info.sentence,
    }]
    return JsonResponse(list2,safe=False)

def getinfotwo(request):
    id=request.GET["id"]
    info=Booktwo.objects.get(id=id)
    list2 = [{
        "id": f"{info.id}",
        "isbn": info.isbn,
        "bookname": info.bookname,
        "publishertime": info.publishertime,
        "sentence":info.sentence,
    }]
    return JsonResponse(list2,safe=False)

def addinfotwo(request):
    id=request.GET["id"]
    isbn=request.GET["isbn"]
    bookname=request.GET["bookname"]
    publishertime=request.GET["publishertime"]
    sentence=request.GET["sentence"]
    Booktwo.objects.create(id=id,isbn=isbn,bookname=bookname,publishertime=publishertime,sentence=sentence)
    return JsonResponse({"code":0,"message":"add info sucessfully"})

def login(request):
    try:
        user=request.GET["user"]
        password=request.GET["password"]
        Login.objects.get(user=user,password=password)
        return HttpResponse({0})
    except:
        return HttpResponse({1})

def register(request):
    user=request.GET["user"]
    password=request.GET["password"]
    Login.objects.create(user=user,password=password)
    return HttpResponse({0})

def addone(request):
    isbn=request.GET["isbn"]
    bookname=request.GET["bookname"]
    publishertime=request.GET["publishertime"]
    sentence=request.GET["sentence"]
    Bookone.objects.create(isbn=isbn,bookname=bookname,publishertime=publishertime,sentence=sentence)
    return JsonResponse({"code":0,"message":"add info sucessfully"})

def deleteone(request):
    id = request.GET["id"]
    Bookone.objects.filter(id=id).delete()
    return JsonResponse({"code": 0, "message": "delete info successfully"})


"""week18 URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from stapp import views as stapp_views

urlpatterns = [
    path('admin/', admin.site.urls),

    path("login/",stapp_views.login),
    path("register/",stapp_views.register),

    path("addinfo/",stapp_views.addinfo),
    path("deleteinfo/",stapp_views.deleteinfo),
    path("updateinfo/",stapp_views.updateinfo),
    path("getinfo/",stapp_views.getinfo),
    path("testdb/",stapp_views.testdb),

    path("testdbone/",stapp_views.testdbone),
    path("testdbtwo/",stapp_views.testdbtwo),

    path("getinfoone/",stapp_views.getinfoone),
    path("getinfotwo/",stapp_views.getinfotwo),

    path("addone/",stapp_views.addone),
    path("deleteone/",stapp_views.deleteone),
]

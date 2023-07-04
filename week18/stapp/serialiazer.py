from rest_framework import serializers
from stapp.models import Book
 
class StudentModelSerializer(serializers.ModelSerializer):
    class Meta:
        model = Book
        fields = "__all__"
        # 设置年龄限制，并设置报错信息
        extra_kwargs = {
            "age":{
                "max_value":25,
                "error_messages": {
                    "max_value":"年龄不能超过25岁",
                }
            }
        }
# Generated by Django 4.0 on 2023-07-01 15:03

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Book',
            fields=[
                ('id', models.AutoField(max_length=100, primary_key=True, serialize=False)),
                ('isbn', models.CharField(max_length=15, null=True)),
                ('bookname', models.CharField(max_length=10, null=True)),
                ('publishertime', models.DateField(null=True)),
                ('picture', models.CharField(max_length=200, null=True)),
                ('sentence', models.CharField(max_length=500, null=True)),
            ],
        ),
        migrations.CreateModel(
            name='Bookone',
            fields=[
                ('id', models.CharField(max_length=100, primary_key=True, serialize=False)),
                ('isbn', models.CharField(max_length=15, null=True)),
                ('bookname', models.CharField(max_length=10, null=True)),
                ('publishertime', models.CharField(max_length=500, null=True)),
                ('sentence', models.CharField(max_length=500, null=True)),
            ],
        ),
        migrations.CreateModel(
            name='Booktwo',
            fields=[
                ('id', models.CharField(max_length=100, primary_key=True, serialize=False)),
                ('isbn', models.CharField(max_length=15, null=True)),
                ('bookname', models.CharField(max_length=10, null=True)),
                ('publishertime', models.CharField(max_length=500, null=True)),
                ('sentence', models.CharField(max_length=500, null=True)),
            ],
        ),
    ]

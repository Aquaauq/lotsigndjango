# Generated by Django 4.0 on 2023-07-03 13:44

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('stapp', '0004_alter_bookone_id_alter_booktwo_id'),
    ]

    operations = [
        migrations.AlterField(
            model_name='bookone',
            name='id',
            field=models.CharField(max_length=100, primary_key=True, serialize=False),
        ),
        migrations.AlterField(
            model_name='booktwo',
            name='id',
            field=models.CharField(max_length=100, primary_key=True, serialize=False),
        ),
    ]

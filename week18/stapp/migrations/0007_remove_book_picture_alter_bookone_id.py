# Generated by Django 4.0 on 2023-07-03 13:51

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('stapp', '0006_alter_bookone_id'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='book',
            name='picture',
        ),
        migrations.AlterField(
            model_name='bookone',
            name='id',
            field=models.CharField(max_length=15, primary_key=True, serialize=False),
        ),
    ]
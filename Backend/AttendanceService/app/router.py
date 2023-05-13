import base64
import PIL.Image as Image
import io
import json
from .config import loop, KAFKA_BOOTSTRAP_SERVERS,KAFKA_CONSUMER_GROUP,KAFKA_TOPIC
from aiokafka import AIOKafkaConsumer
from fastapi import APIRouter
from database import cursor
router = APIRouter()

def add_to_table(student_id,face_encoding):
    query = ("INSERT INTO faceencode (student_id,face_encoding)\
             values ({},{});".format(student_id,face_encoding))
    cursor.execute(query)


async def consumer(): 
    consumer = AIOKafkaConsumer(KAFKA_TOPIC, loop= loop, bootstrap_servers= KAFKA_BOOTSTRAP_SERVERS, group_id= KAFKA_CONSUMER_GROUP )
    await consumer.start()
    try:
        async for msg in consumer:
            json_load = json.loads(msg.value)
            json_load_image_byte = json_load['byteArray']
            json_load_student_code = json_load['studentCode']
              
            
            
    finally:
        await consumer.stop()
# loop.run_until_complete(consumer())
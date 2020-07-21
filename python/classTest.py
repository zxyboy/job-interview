import json

filePath = "/Users/xy/IdeaProjects/job-interview/python/user.json"
with open(filePath, 'r') as file:
    # 将lists保存到user.json文件中
    lists = json.load(file)
print(lists)

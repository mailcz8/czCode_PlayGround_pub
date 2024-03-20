from datetime import datetime
from pytube import YouTube
import os, re

# Check this web site for more pytube help
# https://medium.com/@nutanbhogendrasharma/how-to-download-youtube-videos-using-python-5d5e85f2cbea

# where to save  
# SAVE_PATH = "E:/"  # to_do

# link of the video to be downloaded
# link = "https://www.youtube.com/watch?v=Wdq_pRXwg_8"
link = "https://www.youtube.com/watch?v=Q2cMMnUuKYQ"
# link = "monday"
yt = YouTube(link)

def get_file_path():
    # print("List if current dir: ", os.listdir())
    expectDir = "1_media_download_temp"

    if expectDir in os.listdir():
        print("Expected directory found: " + expectDir)
    else:
        print("Expected dir not found, creating one: " + expectDir)
        os.mkdir(expectDir)
    os.chdir(expectDir)
    save_video_path = os.path.abspath(".")
    print("Save file to path: ", save_video_path)
    return save_video_path

def dl_yt_media(fileType='mp4',fileSize='1080p'):
    save_video_path = get_file_path()
    print("save youTube: ",link," to dir = ", save_video_path)
    try:
        # object creation using YouTube 
        # which was imported in the beginning  
        print("YouTube title: ", yt.title.lower(), " link: ", link, " to dir = ", save_video_path)
        if fileType.lower() in ('video', 'mp4'):
            file_name = re.split(":| - |\\(|!|;", yt.title.lower())
            file_name = file_name[0].lstrip().rstrip()
            output_file_name = file_name.replace(" ","_")+".mp4"
            if fileSize=='1080p':
                # 1080P /24fps video mp4
                # stream = yt.streams.get_by_itag(137) # 1080P /24fps video mp4
                stream = yt.streams.filter(file_extension='mp4', progressive=True, res='1080p')
            elif fileSize=='720p':
                # 720P /24fps video mp4
                # stream = yt.streams.get_by_itag(22) # 720P /24fps video mp4
                stream = yt.streams.filter(file_extension='mp4', progressive=True, res='720p')
            else:
                # 360p /24fps video mp4
                # stream = yt.streams.get_by_itag(18) # 360p /24fps video mp4
                stream = yt.streams.filter(file_extension='mp4', progressive=True, res='360p')
        if fileType.lower() in ('audio', 'mp3', 'audio_only', 'song', 'songs'):
            file_name = re.split(":| - |\\(|!|;", yt.title.lower())
            file_name = file_name[0].lstrip().rstrip()
            output_file_name = file_name.replace(" ","_")+".mp3"
        else:
            temp_title = datetime.now().strftime("%Y%m%d_%H%M%S")+"_yt_video_dl"+".mp4"
            output_file_name = temp_title.replace(" ","_")+".mp4"
            stream = yt.streams.filter(file_extension='mp4', progressive=True)
        # print("YT file deatil: ", yt.streams)
        print(f"Downloading YouTube video successfully at {save_video_path} and file name is {output_file_name}.")
        # stream = yt.streams.get_by_itag(22) # 720P /24fps video mp4
        # stream = yt.streams.get_by_itag(137) # 1080P /24fps video mp4
        # stream = yt.streams.get_by_itag(18) # 360p /24fps video mp4
        # stream.download(output_path = save_video_path, filename = output_file_name)
        print(f"YouTube video downloaded successfully at {save_video_path} and file name is {output_file_name}.")
    except Exception as E:
        print("Connection Error")  # to handle exception

def dl_yt_video():
    # filters out all the files with "mp4" extension  
    # mp4files = yt.filter('mp4')
    # mp4files = yt.streams.filter(file_extension='mp4')
    mp4files = yt.streams.filter(file_extension='mp4', progressive=True)
    # mp3files = yt.filter('mp3')
            # get the video with the extension and 
        # resolution passed in the get() function  
        # d_video = yt.get(mp4files[-1].extension, mp4files[-1].resolution)
        # print(d_video)
        # d_video.download(SAVE_PATH)

    # filters out all the files with "mp4" extension  
    # mp4files = yt.filter('mp4')
    # mp4files = yt.streams.filter(file_extension='mp4')
    # mp3files = yt.filter('mp3')
        
    # try:
    #     # downloading the video
    #     d_video.download(SAVE_PATH)
    # except:
    #     print("Some Error!")
    # print('Task Completed!')
    pass


# dl_yt_file(fileType='mp4')
dl_yt_media('mp4')

from pytube import YouTube
import os, re

# Check this web site for more pytube help
# https://medium.com/@nutanbhogendrasharma/how-to-download-youtube-videos-using-python-5d5e85f2cbea

# where to save  
# SAVE_PATH = "E:/"  # to_do

def get_file_path():
    print("List if current dir: ", os.listdir())
    expectDir = "1_all_workout"

    if expectDir in os.listdir():
        print("Expected directory found: " + expectDir)
    else:
        print("Expected dir not found, creating one: " + expectDir)
        os.mkdir(expectDir)
    os.chdir(expectDir)
    save_video_path = os.path.abspath(".")
    print("Save file to path: ", save_video_path)
    return save_video_path
save_video_path = get_file_path()

# link of the video to be downloaded
# link = "https://www.youtube.com/watch?v=Wdq_pRXwg_8"
link = "https://www.youtube.com/watch?v=Q2cMMnUuKYQ"

print("save youTube: ",link," to dir = ", save_video_path)

try:
    # object creation using YouTube 
    # which was imported in the beginning  
    yt = YouTube(link)
    print("xxx = ", yt, "\n", yt.title.lower())
    useTitle = True
    if useTitle:
        file_name = re.split(":| - |\\(|!|;", yt.title.lower())
        file_name = file_name[0].lstrip().rstrip()
        output_file_name = file_name.replace(" ","_")+".mp4"
    else:
        this_title = "10_min_lower_ab_workout"
        output_file_name = this_title.replace(" ","_")+".mp4"
    print(yt.streams)
    print("output_file_name = " + output_file_name)
except Exception as E:
    print("Connection Error")  # to handle exception

# try:
#     yt = YouTube(link)
#     print(yt)
#     pass
# except Exception as error:
#     print(f"Error: {error}")
#     pass

# filters out all the files with "mp4" extension  
# mp4files = yt.filter('mp4')
# mp4files = yt.streams.filter(file_extension='mp4')
mp4files = yt.streams.filter(file_extension='mp4', progressive=True)
# mp3files = yt.filter('mp3')

# to set the name of the file
print(dir(yt))
# yt.set_filename('this_youtube_video')

try:
    stream = yt.streams.get_by_itag(22)
    stream.download(output_path = save_video_path, filename = output_file_name)
    print(f"YouTube video downloaded successfully at {save_video_path} and file name is {output_file_name}.")
except Exception as error:
    print(f"Error while downloading the video: {error}")
    pass

# get the video with the extension and 
# resolution passed in the get() function  
# d_video = yt.get(mp4files[-1].extension, mp4files[-1].resolution)
# print(d_video)

# try:
#     # downloading the video
#     d_video.download(SAVE_PATH)
# except:
#     print("Some Error!")
# print('Task Completed!')
# import youtube_dl
from pytube import YouTube
import os, sys, re

class YouTube_DL():
    def __init__(self):
        self.youtube_url = ""
        # self.destination = ".\\new_yt_media_dl"

    def check_yt_url(self):
        try:
            if sys.argv[1] != None:
                print("User enter url: ", sys.argv[1])
                self.youtube_url = sys.argv[1]
            if len(sys.argv) <= 1:
                self.youtube_url = input("Enter the URL of the video you want to download: \n>> ")
            else:
                self.youtube_url = sys.argv[1]
        except Exception as err:
            print(err)
            print("No url was entered at command line...")
            # self.youtube_url = "https://www.youtube.com/watch?v=2r7pq4XbUL4" #70、80、90年代经典老歌
            # self.youtube_url = "https://www.youtube.com/watch?v=AMskvxEWf0k" #Big Fish (大魚)
        print("YT dl url set to: ", self.youtube_url)
        return self.youtube_url

    def pytube_mp3_only(self, youtube_url):
        # url input from user
        try:
            if youtube_url != '':
                yt = YouTube(youtube_url)
            elif len(sys.argv) <= 1:
                # yt = str(input("Enter the URL of the video you want to download: \n>> "))
                # yt = YouTube(str(input("Enter the URL of the video you want to download: \n>> ")))
                yt = YouTube(input("Enter the URL of the video you want to download: \n>> "))
            else:
                print("Missing youtube_url:", len(sys.argv), sys.argv[1])
                # yt = YouTube("https://www.youtube.com/watch?v=AMskvxEWf0k")
        except Exception as err:
            print(err)

        # extract only audio
        dl_file = yt.streams.filter(only_audio=True).first()
            
        # extract video + audio in 1080p
        # dl_file = yt.streams.filter(file_extension='mp4', progressive=True, res='1080p')
        # dl_file = yt.streams.filter(file_extension='mp4', progressive=True, res='1080p')
        # stream = yt.streams.get_by_itag(137) # 1080P /24fps video mp4

        # check for destination to save file
        print("Enter the destination (leave blank for current directory).")
        print("current dir path: ", os.path.abspath(os.getcwd()))
        # destination = str(input(">> ")) or '.'
        destination = "testdir1"

        # download the file
        dl_now = True
        if dl_now:
            out_file = dl_file.download(output_path=destination)
            print("YT audio dl only for: ", yt.title)
            # save the file
            base, ext = os.path.splitext(out_file)
            new_file = base + '.mp4'
            os.rename(out_file, new_file)

        # result of success
        print(yt.title + " has been successfully downloaded.")

    def pytube_video_mp4(self,link='', video_res='1080p'):
        print("Trying download -- yt_video_mp4 --: ", link)
        yt = YouTube(link)
        file_name = re.split(":| - |\\(|!|;", yt.title.lower())
        file_name = file_name[0].lstrip().rstrip()
        file_path = 'dl_mp4_only'
        print("file pull path: ", os.pardir)
        if video_res == '360p':
            print("Download YT file titl in 360p: ", yt.title)
            stream = yt.streams.get_by_itag(18) # 360p /24fps video mp4
            output_file_name = file_name.replace(" ","_")+"-360p"+".mp4"
        elif video_res == '720p':
            print("Download YT file titl in 720p: ", yt.title)
            stream = yt.streams.get_by_itag(22) # 720P /24fps video mp4
            output_file_name = file_name.replace(" ","_")+"-720p"+".mp4"
        elif video_res == 'high':
            stream = yt.streams.filter(file_extension='mp4', progressive=True)
            print("Download YT file titl in 1080p: ", yt.title)
            print(f"Downloading YouTube video successfully at {save_video_path} and file name is {output_file_name}.")
            # stream.download(output_path = save_video_path, filename = output_file_name)
        else:
            stream = yt.streams.filter(file_extension='mp4', progressive=True, res='1080p')
            # stream = yt.streams.get_by_itag(137) # 1080P /24fps video mp4
            output_file_name = file_name.replace(" ","_")+"-1080p"+".mp4"
        print(f"Downloading YouTube video successfully at {file_path} and file name is {output_file_name}.")
        stream.download(output_path = file_path, filename = output_file_name)
        print(f"YouTube video downloaded successfully at {file_path} and file name is {output_file_name}.")

if __name__=='__main__':
    x = YouTube_DL()
    # x.check_yt_url()
    this_url = "https://www.youtube.com/watch?v=Ufs7vpQAm1U"
    # x.pytube_mp3_only(this_url)
    x.pytube_video_mp4(this_url)

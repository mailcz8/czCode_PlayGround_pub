import youtube_dl
from pytube import YouTube
import os, sys

class YouTube_DL():
    def __init__(self):
        try:
            self.youtube_url = sys.argv[1]
        except Exception as err:
            print(err)
            # self.youtube_url = "https://www.youtube.com/watch?v=2r7pq4XbUL4" #70、80、90年代经典老歌

    def youtube_dl_mp3(self):
        # if sys_arg != "",

        # video_url = input("please enter youtube video url:")
        # video_url = "https://www.youtube.com/watch?v=g27sCxR04gU"
        video_url = self.youtube_url
        video_info = youtube_dl.YoutubeDL().extract_info(url=video_url, download=False)
        filename = video_info['title']+".mp3"
        print("Song {} will be DL!!!".format(filename))
        options = {
            'format': 'bestaudio/best',
            'keepvideo': False,
            'outtmpl': filename,
            }

        with youtube_dl.YoutubeDL(options) as ydl:
            ydl.download([video_info['webpage_url']])

        print("Download complete... {}".format(filename))

    def pytube_mp3_only(self):
        # url input from user
        yt = YouTube(str(input("Enter the URL of the video you want to download: \n>> ")))

        # extract only audio
        video = yt.streams.filter(only_audio=True).first()

        # check for destination to save file
        print("Enter the destination (leave blank for current directory)")
        destination = str(input(">> ")) or '.'

        # download the file
        out_file = video.download(output_path=destination)

        # save the file
        base, ext = os.path.splitext(out_file)
        new_file = base + '.mp3'
        os.rename(out_file, new_file)

        # result of success
        print(yt.title + " has been successfully downloaded.")

    def run(self):
        if self.youtube_url == '':
            print("There is no sys_arg")
        else:
            print(self.youtube_url)

if __name__=='__main__':
    x = YouTube_DL()
    x.run()
    x.youtube_dl_mp3()
    # x.pytube_mp3_only()



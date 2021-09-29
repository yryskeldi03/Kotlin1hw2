package kg.geek.kotlin1hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geek.kotlin1hw2.databinding.ActivityMainBinding
import kg.geek.kotlin1hw2.extansions.load
import kg.geek.kotlin1hw2.extansions.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var imgUrls = arrayListOf(
        "https://cutewallpaper.org/21/avengers-endgame-poster-4k/Avengers-Endgame-Official-Poster-4k.jpg",
        "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/7d09ec8c-cc7e-4886-86b8-0bb8b6f623cf/degef62-b8ab7ed6-9505-409b-a0bc-a20bcad2545a.jpg/v1/fill/w_1280,h_1897,q_75,strp/zack_snyder_s_justice_league_fan_made_poster_by_bodie96_degef62-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTg5NyIsInBhdGgiOiJcL2ZcLzdkMDllYzhjLWNjN2UtNDg4Ni04NmI4LTBiYjhiNmY2MjNjZlwvZGVnZWY2Mi1iOGFiN2VkNi05NTA1LTQwOWItYTBiYy1hMjBiY2FkMjU0NWEuanBnIiwid2lkdGgiOiI8PTEyODAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.WrJk1on4P33yIyTkz0ckWD1ch--u4OcfjsoS_K6BdeI",
        "https://image.posterlounge.com/images/l/1893822.jpg",
        "https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTynHfBuLHkLUNPZFkIHShI0Z4NL2-h-wC76Q&usqp=CAU"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitImg.setOnClickListener {
            if (binding.etInputImgUrl.text.toString().isEmpty()) {
                showToast(getString(R.string.enter_your_uri))
            } else {
                imgUrls.add(binding.etInputImgUrl.text.toString())
                binding.etInputImgUrl.setText("")
                showToast(getString(R.string.successfully_sent))
            }
        }

        binding.btnRandomImg.setOnClickListener {
            binding.imageView.load(imgUrls.random())
        }
    }
}
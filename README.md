<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
# Android-Ubin

![github_김우빈_ver1-4](https://user-images.githubusercontent.com/70698151/135753275-340450e7-f3fc-4bfe-aedc-4fed88988a87.png)
=======
SoptAndroid
>>>>>>> Initial commit
=======
=======
# 시연영상
![ezgif-4-d5f0e03ac685](https://user-images.githubusercontent.com/54489627/138398283-030c617e-5322-42a3-825c-df5e757317df.gif)

~~디자인은 포기한다~~

>>>>>>> Update README.md
# 1주차 과제
* 빈 곳이 있을 때는 "입력되지않은 정보가 있습니다" 토스트메시지가 출력되게 했씁니다.
* 필수과제에 있는 뷰를 만들었습니다.
### 도전과제
* registerForActivityResult와 putExtra를 이용해 회원가입 후 입력된 정보가 로그인 화면에 입력되도록 하였습니다.


``` kotlin
activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val id=it.data?.getStringExtra("id")
                signInViewModel.idText.value=id
                signInViewModel.pwdText.value=it.data?.getStringExtra("pwd")
            }
        }
```
* 2-2 : 명시적 인텐트와 암시적 인텐트

명시적 인텐트는 인텐트에 Activity::class.java와 같이 액티비티를 실행해달라고 명확하게 의미를 전달하는 인텐트입니다.
암시적 인텐트는 클래스명이나 패키지명을 넣지않고 암시적으로 주어진 인텐트를 처리할 수 있는 액티비티를 찾아서 실행해주는 인텐트입니다.

* 2-3 : 시연영상에서와 같이 constraintDimensionRatio를 통해 사진비율을 맞추고 NestedScrollView를 통해 길어지더라고 스크롤이 가능하도록 하였습니다.

### 심화과제
* 3-1: 바인딩어댑터를 통해 사진을 띄우도록 하였습니다
``` kotlin
object BindingAdapters {
    @BindingAdapter("setHomeImage")
    @JvmStatic
    fun setHomeImage(imageView: ImageView,resource:Int){
        imageView.setImageResource(resource)
    }

}
``` 
추후에 사용 할 수 있기 때문에 바인딩어댑터 object를 만들었습니다.
또한 ViewModel을 사용하였기 때문에 자연스럽게 DataBinding을 이용해 HomeActivity의 텍스트 뿐 아니라 로그인, 회원가입때의 EditText에도 적용하였습니다.
* 3-2 : 코틀린에서 setOnClickListener를 람다식으로 간결하게 표현가능 한 이유?

 코틀린에서는 Single Abstract Method Conversions이 제공됩니다. 이를 SAM 변환이라고 합니다. 코틀린에서는 이 이름과 같이 추상 메서드 하나를 인수로 사용할 때는 함수를 인수로 전달할 수 있습니다. 그래서 구현하는 인터페이스가 하나일때 람다식으로 편하게 표기하였습니다.
 
 # 2주차
 ### 필수과제
 - 시연영상에서와 같이 팔로워목록은 GridLayout을 이용한 Recyclerview를 넣어주었고 레포지토리 목록은 일반 Linear Layout을 이용한 RecyclerView를 넣어주었습니다.
 - 각 버튼을 누르면 그에 맞는 Fragment가 나오게 하였습니다.
 
 ### 심화과제
 - 3-1 : 보일러 플레이트 코드의 처리
 
 액티비티와 Fragment의 중복된 부분을 효율적으로 사용하기 위해 추상 클래스를 이용하여 공통된 부분을 모아 이후 재사용 할 수 있도록 하였습니다.
 
 ``` kotlin
 //액티비티들을 쉽게 사용하기 위한 추상 클래스
 abstract class BindingActivity<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
    }

    protected inner class LifeCycleEventLogger(private val className: String) : LifecycleObserver {
        fun registerLogger(lifecycle: Lifecycle) {
            lifecycle.addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        fun log() {
            Log.d("${className}LifeCycleEvent", "${lifecycle.currentState}")
        }
    }
}
```


``` kotlin
// Fragment에서 재사용이 가능한 추상클래스

abstract class BindingFragment<T : ViewBinding> : Fragment() {
    protected var _binding: T? = null
    protected val binding get() = _binding ?:error("Binding이 초기화 되지 않았습니다.")
   
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getFragmentBinding(inflater,container)
        return binding.root
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
```
  
- 3-2: DiffUtil을 통한 notifyDataSetChanged 개선
 
  ``` kotlin
  private class FollowerDiffUtil : DiffUtil.ItemCallback<FollowerData>() {
        override fun areItemsTheSame(
            oldItem: FollowerData,
            newItem: FollowerData
        ) =
            (oldItem.information == newItem.information)

        override fun areContentsTheSame(
            oldItem: FollowerData,
            newItem: FollowerData
        ) =
            (oldItem == newItem)
    }
  ```
  
  Adapter를 ListAdapter로 사용하면서 DiffUtil Callback을 넣어주어 아이템 갱신이 자동으로 되도록 하였습니다.
  
  notifyDataSetChanged를 쓰게 되면 리스트를 갱신하기위해 리스트를 모두 바꾸기 때문에 통째로 업데이트 할때 아이템이 많을수록 지연이슈가 생깁니다. ~~화면 깜빡임은 덤~~
  그래서 DiffUtil은 현재 데이터리스트와 교체될 리스트를 비교하고 바꾸어야할 데이터만 바꿔줌으로 빠르게 갱신이 가능합니다.
<<<<<<< HEAD
  출처:https://velog.io/@l2hyunwoo/Android-RecyclerView-DiffUtil-ListAdapter ~~누누야 갓맙다~~
>>>>>>> Update README.md
=======
  출처:https://velog.io/@l2hyunwoo/Android-RecyclerView-DiffUtil-ListAdapter 
  ~~누누야 갓맙다~~
>>>>>>> Update README.md

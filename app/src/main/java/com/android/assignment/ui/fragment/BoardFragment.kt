package com.android.assignment.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.assignment.R
import com.android.assignment.binding.FragmentDataBindingComponent
import com.android.assignment.databinding.FragmentBoardBinding
import com.android.assignment.di.Injectable
import com.android.assignment.model.Image
import com.android.assignment.ui.adapter.BoardAdapter
import com.android.assignment.util.AppExecutors
import com.android.assignment.util.autoCleared
import javax.inject.Inject

/**
 * A placeholder fragment containing images of a board.
 */
class BoardFragment : Fragment(), Injectable {

    @Inject
    lateinit var appExecutors: AppExecutors
    lateinit var imageList: ArrayList<Image>
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    var binding by autoCleared<FragmentBoardBinding>()
    var boardAdapter by autoCleared<BoardAdapter>()
    private lateinit var callback: BoardCallback

    interface BoardCallback {
        fun showImage(view: View, image: Image)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as BoardCallback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageList = arguments?.getParcelableArrayList<Image>(ARG_IMAGES) as ArrayList<Image>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_board, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        boardAdapter = BoardAdapter(
            dataBindingComponent = dataBindingComponent,
            appExecutors = appExecutors, clickCallback = {view, image ->
                callback.showImage(view, image)
            })

        binding.imageList.adapter = boardAdapter

        initRecyclerView()
    }

    private fun initRecyclerView() {
        boardAdapter.submitList(imageList)
    }

    companion object {
        /**
         * The fragment argument representing the images of a board.
         */
        private const val ARG_IMAGES = "images"

        /**
         * Returns a new instance of this fragment for the given category.
         */
        @JvmStatic
        fun newInstance(imageList: ArrayList<out Image>): BoardFragment {
            return BoardFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_IMAGES, imageList)
                }
            }
        }
    }
}
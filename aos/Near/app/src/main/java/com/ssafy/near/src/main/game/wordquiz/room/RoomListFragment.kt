package com.ssafy.near.src.main.game.wordquiz.room

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.near.R
import com.ssafy.near.config.BaseFragment
import com.ssafy.near.databinding.FragmentRoomListBinding
import com.ssafy.near.dto.RoomInfo
import com.ssafy.near.repository.GameRepository
import com.ssafy.near.src.main.game.wordquiz.WordQuizViewModel
import com.ssafy.near.src.main.game.wordquiz.WordQuizViewModelFactory


class RoomListFragment : BaseFragment<FragmentRoomListBinding>(R.layout.fragment_room_list) {
    private lateinit var wordQuizViewModel: WordQuizViewModel
    private lateinit var roomListAdapter: RoomListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        initEvent()
    }
    
    private fun initViewModel() {
        wordQuizViewModel = ViewModelProvider(requireActivity(), WordQuizViewModelFactory(
            GameRepository())).get(WordQuizViewModel::class.java)
        
        wordQuizViewModel.getRoomList().observe(viewLifecycleOwner) {
            roomListAdapter.apply {
                roomList = it
                notifyDataSetChanged()
            }
        }
    }

    private fun initView() {
        roomListAdapter = RoomListAdapter()
        binding.rvRoomList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = roomListAdapter
        }

        wordQuizViewModel.loadRooms()
    }

    private fun initEvent() {
        binding.ivExitGame.setOnClickListener {
            requireActivity().finish()
        }

        binding.ivRefresh.setOnClickListener {
            wordQuizViewModel.loadRooms()
        }

        binding.fbCreate.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_room, CreatingRoomFragment())
                .addToBackStack(null)
                .commit()
        }

        roomListAdapter.setItemClickListener(object : RoomListAdapter.ItemClickListener {
            override fun onClick(roomInfo: RoomInfo) {
                (context as RoomActivity).enterRoom(roomInfo)
            }
        })
    }
}
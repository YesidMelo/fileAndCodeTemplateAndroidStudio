package ${PACKAGE_NAME}.ui.fragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ${PACKAGE_NAME}.R
import ${PACKAGE_NAME}.databinding.FragmentSecondBinding
import ${PACKAGE_NAME}.ui.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : BaseFragment<SecondViewModel>() {

    private var _binding: FragmentSecondBinding? = null
    @Inject lateinit var secondViewModel: SecondViewModel 
    
    override fun traerViewModel(): SecondViewModel = secondViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            secondViewModel.showError()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}